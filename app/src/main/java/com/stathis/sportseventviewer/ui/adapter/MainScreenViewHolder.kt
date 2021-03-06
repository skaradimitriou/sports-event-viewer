package com.stathis.sportseventviewer.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeCategoryItemBinding
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.util.IconHelper

class MainScreenViewHolder(val binding: HolderHomeCategoryItemBinding,val callback : SportsClickListener) : RecyclerView.ViewHolder(binding.root) {

    fun present(data: LocalModel) {
        when (data) {
            is ResponseModel -> {
                binding.root.tag = data

                val list = IconHelper.getSports()

                list.forEach {
                    when(it.title == data.sportName){
                        true -> Glide.with(itemView).load(it.imageUrl).into(binding.categoryIcon)
                        false -> Unit
                    }
                }

                val adapter = MainChildAdapter(callback)
                adapter.submitList(data.events)

                binding.adapter = adapter
                binding.model = data
            }
        }
    }
}