package com.stathis.sportseventviewer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.abstraction.AbstractActivity
import com.stathis.sportseventviewer.databinding.ActivityMainBinding
import com.stathis.sportseventviewer.network.ApiClient

class MainActivity : AbstractActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var viewModel : MainViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {
        binding.homeScreenRecycler.adapter = viewModel.adapter

        viewModel.observe(this)
    }

    override fun stopOps() {
        viewModel.release(this)
    }
}