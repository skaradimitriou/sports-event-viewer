package com.stathis.sportseventviewer.util

import android.widget.TextView
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

        @BindingAdapter("player1")
        @JvmStatic
        fun TextView.setPlayer1(players : String){
            this.text = players.substringBefore("-").trim()
        }

        @BindingAdapter("player2")
        @JvmStatic
        fun TextView.setPlayer2(players : String){
            this.text = players.substringAfter("-").trim()
        }
    }
}