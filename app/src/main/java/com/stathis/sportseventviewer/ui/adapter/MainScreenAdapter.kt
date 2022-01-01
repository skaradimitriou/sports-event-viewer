package com.stathis.sportseventviewer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.sportseventviewer.abstraction.DiffUtilClass
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeCategoryItemBinding
import com.stathis.sportseventviewer.models.LocalModel
import kotlin.math.exp

class MainScreenAdapter(val callback : SportsClickListener) : ListAdapter<LocalModel,MainScreenViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val view = HolderHomeCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainScreenViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}