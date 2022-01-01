package com.stathis.sportseventviewer.ui

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.stathis.sportseventviewer.abstraction.AbstractViewModel
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.dinjection.DaggerApiComponent
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.models.SportsModel
import com.stathis.sportseventviewer.network.ApiClient
import com.stathis.sportseventviewer.ui.adapter.MainScreenAdapter
import javax.inject.Inject

class MainViewModel(app : Application) : AbstractViewModel(app),SportsClickListener {

    @Inject
    lateinit var api: ApiClient

    val adapter by lazy { MainScreenAdapter(this) }
    val success = MutableLiveData<List<ResponseModel>>()
    val error = MutableLiveData<Boolean>()
    private var isExpanded = false
    private var isFavorite = false

    init {
        DaggerApiComponent.create().inject(this)

        getData()
    }

    fun getData(){
        api.getSports(success,error)
    }

    fun observe(owner: LifecycleOwner){
        success.observe(owner, Observer {
            Log.d("DATA",it.toString())
            adapter.submitList(it)
        })
    }

    fun release(owner: LifecycleOwner){
        success.removeObservers(owner)
    }

    private fun checkIfFavorite(model : SportsModel) : Boolean {
        return false

        addToFavorites(model)
    }

    private fun addToFavorites(model : SportsModel) {
        isFavorite = !isFavorite
    }

    override fun onItemTap(view: View) {
        when(view.tag){
            is ResponseModel -> changeExpandView()
            is SportsModel -> checkIfFavorite(view.tag as SportsModel)
        }
    }

    private fun changeExpandView() {
        //FIXME: Implement expand view
    }
}