package com.stathis.sportseventviewer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.sportseventviewer.abstraction.DiffUtilClass
import com.stathis.sportseventviewer.databinding.HolderHomeCategoryItemBinding
import com.stathis.sportseventviewer.databinding.HolderHomeSportsItemBinding
import com.stathis.sportseventviewer.models.LocalModel

class MainChildAdapter() : ListAdapter<LocalModel, MainChildViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainChildViewHolder {
        val view = HolderHomeSportsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainChildViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}