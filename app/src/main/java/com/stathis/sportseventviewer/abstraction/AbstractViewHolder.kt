package com.stathis.sportseventviewer.abstraction

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.stathis.sportseventviewer.models.LocalModel

abstract class AbstractViewHolder(itemView : ViewDataBinding) : RecyclerView.ViewHolder(itemView.root) {

    fun bindData(data: LocalModel) {
        itemView.tag = data
        present(data)
    }

    abstract fun present(data: LocalModel)
}