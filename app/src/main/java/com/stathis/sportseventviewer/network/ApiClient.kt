package com.stathis.sportseventviewer.network

import androidx.lifecycle.MutableLiveData
import com.stathis.sportseventviewer.dinjection.DaggerApiComponent
import com.stathis.sportseventviewer.models.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiClient {

    @Inject
    lateinit var service : Endpoints

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getSports(data : MutableLiveData<List<ResponseModel>>, error : MutableLiveData<Boolean>) {
        service.getSports().enqueue(object : Callback<List<ResponseModel>>{
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {

                //FIXME: Find a way to set default true value to response model isExpandable

                val response = response.body()

                response?.forEach {
                    it.isExpandable = true
                }
                response?.let { data.value = it }
                error.value = false
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                error.value = true
            }
        })
    }
}