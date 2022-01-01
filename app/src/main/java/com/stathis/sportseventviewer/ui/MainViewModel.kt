package com.stathis.sportseventviewer.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.stathis.sportseventviewer.abstraction.AbstractViewModel
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.network.ApiClient
import com.stathis.sportseventviewer.ui.adapter.MainChildAdapter
import com.stathis.sportseventviewer.ui.adapter.MainScreenAdapter

class MainViewModel(app : Application) : AbstractViewModel(app) {

    val adapter by lazy { MainScreenAdapter() }
    val success = MutableLiveData<List<ResponseModel>>()
    val error = MutableLiveData<Boolean>()

    init {
        getData()
    }

    fun getData(){
        ApiClient.getSports(success,error)
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
}