package com.stathis.sportseventviewer.ui

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.stathis.sportseventviewer.abstraction.AbstractViewModel
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.dinjection.DaggerApiComponent
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.models.SportsModel
import com.stathis.sportseventviewer.network.ApiClient
import com.stathis.sportseventviewer.ui.adapter.MainScreenAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(app : Application) : AbstractViewModel(app),SportsClickListener {

    @Inject
    lateinit var api: ApiClient

    val adapter by lazy { MainScreenAdapter(this) }
    val success = MutableLiveData<List<ResponseModel>>()
    val error = MutableLiveData<Boolean>()

    init {
        DaggerApiComponent.create().inject(this)

        getData()
    }

    fun getData(){
        CoroutineScope(Dispatchers.IO).launch {
            api.getSports(success,error)
        }
    }

    fun observe(owner: LifecycleOwner){
        success.observe(owner, Observer { list ->
            Log.d("DATA",list.toString())
            adapter.submitList(list)
        })
    }

    fun release(owner: LifecycleOwner){
        success.removeObservers(owner)
    }

    override fun onItemTap(view: View) {
        when(view.tag){
            is ResponseModel -> Unit
            is SportsModel -> Unit
        }
    }
}