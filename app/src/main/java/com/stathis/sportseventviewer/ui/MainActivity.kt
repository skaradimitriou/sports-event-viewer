package com.stathis.sportseventviewer.ui

import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.abstraction.AbstractActivity
import com.stathis.sportseventviewer.databinding.ActivityMainBinding

class MainActivity : AbstractActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var viewModel : MainViewModel

    override fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun startOps() {

        /*
        FIXME: 1.Implement collapse - expand on nested recyclerview
               2. Implement countdown timer on child items
               3. Implement add to favorite list.
         */

        supportActionBar?.title = resources.getString(R.string.screen_title)

        binding.homeScreenRecycler.adapter = viewModel.adapter

        viewModel.observe(this)
    }

    override fun stopOps() {
        viewModel.release(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu,menu)
        return true
    }
}