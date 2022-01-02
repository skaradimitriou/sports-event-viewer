package com.stathis.sportseventviewer.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.abstraction.DiffUtilClass
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeCategoryItemBinding
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.ResponseModel
import kotlin.math.exp

class MainScreenAdapter(val callback : SportsClickListener) : ListAdapter<LocalModel,MainScreenViewHolder>(DiffUtilClass<LocalModel>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val view = HolderHomeCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainScreenViewHolder(view,callback)
    }

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        holder.present(getItem(position))

        when(val model = getItem(position)){
            is ResponseModel -> {
                val isExpanded = model.isExpandable

                holder.binding.headerLayout.setOnClickListener {
                    model.isExpandable = !isExpanded
                    notifyItemChanged(holder.adapterPosition)
                }

                when(model.isExpandable){
                    true -> {
                        holder.binding.categoryRecycler.visibility = View.VISIBLE
                        holder.binding.categoryArrow.setImageResource(R.drawable.ic_arrow_facing_up)
                    }
                    false -> {
                        holder.binding.categoryRecycler.visibility = View.GONE
                        holder.binding.categoryArrow.setImageResource(R.drawable.ic_arrow_facing_down)
                    }
                }
            }
        }
    }
}