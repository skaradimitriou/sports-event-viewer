package com.stathis.sportseventviewer.ui

import android.view.Menu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.abstraction.AbstractActivity
import com.stathis.sportseventviewer.databinding.ActivityMainBinding

class MainActivity : AbstractActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var viewModel : MainViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {
        supportActionBar?.title = resources.getString(R.string.screen_title)

        binding.homeScreenRecycler.adapter = viewModel.adapter

        viewModel.observe(this)

        viewModel.error.observe(this, Observer {
            when(it){
                true -> Snackbar.make(binding.mainScreenParent,"Error on getting data from remote", Snackbar.LENGTH_LONG).show()
                false -> Unit
            }
        })
    }

    override fun stopOps() {
        viewModel.release(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu,menu)
        return true
    }
}