package com.stathis.sportseventviewer.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.abstraction.DiffUtilClass
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeCategoryItemBinding
import com.stathis.sportseventviewer.databinding.HolderHomeSportsItemBinding
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.ResponseModel
import com.stathis.sportseventviewer.models.SportsModel

class MainChildAdapter(val callback : SportsClickListener) : ListAdapter<LocalModel, MainChildViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainChildViewHolder {
        val view = HolderHomeSportsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainChildViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: MainChildViewHolder, position: Int) {
        holder.present(getItem(position))

        when(val model = getItem(position)){
            is SportsModel -> {
                val isFavorite = model.isFavorite

                holder.binding.favoriteIcon.setOnClickListener {
                    model.isFavorite = !isFavorite
                    notifyItemChanged(holder.adapterPosition)
                }

                when(isFavorite){
                    true -> holder.binding.favoriteIcon.setImageResource(R.drawable.ic_yellow_star)
                    false -> holder.binding.favoriteIcon.setImageResource(R.drawable.ic_star_outline)
                }
            }
        }
    }
}