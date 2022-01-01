package com.stathis.sportseventviewer.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stathis.sportseventviewer.models.LocalModel

class MyBindingAdapters {

    companion object{

        @BindingAdapter("adapter")
        @JvmStatic
        fun RecyclerView.setRecyclerViewAdapter(adapter: androidx.recyclerview.widget.ListAdapter<LocalModel,RecyclerView.ViewHolder>){
            this.adapter = adapter
        }
    }
}