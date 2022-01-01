package com.stathis.sportseventviewer.dinjection

import com.stathis.sportseventviewer.network.ApiClient
import com.stathis.sportseventviewer.ui.MainViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject (api : ApiClient)
    fun inject (viewModel : MainViewModel)
}