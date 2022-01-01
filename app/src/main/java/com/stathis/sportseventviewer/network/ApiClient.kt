package com.stathis.sportseventviewer.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.util.ENDPOINT_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val service: Endpoints = Retrofit.Builder().baseUrl(ENDPOINT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Endpoints::class.java)

    fun getSports(data : MutableLiveData<List<ResponseModel>>, error : MutableLiveData<Boolean>) {
        service.getSports().enqueue(object : Callback<List<ResponseModel>>{
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                response.body()?.let { data.value = it }
                error.value = false
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                error.value = true
            }
        })
    }
}