package com.stathis.sportseventviewer.dinjection

import com.stathis.sportseventviewer.network.ApiClient
import com.stathis.sportseventviewer.network.Endpoints
import com.stathis.sportseventviewer.util.ENDPOINT_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    fun providePokemonApi() : Endpoints {
        return Retrofit.Builder().baseUrl(ENDPOINT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Endpoints::class.java)
    }

    @Provides
    fun providePokemonService(): ApiClient {
        return ApiClient()
    }
}