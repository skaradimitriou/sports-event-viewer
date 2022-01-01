package com.stathis.sportseventviewer.network

import com.stathis.sportseventviewer.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("api/sports")
    fun getSports() : Call<List<ResponseModel>>
}