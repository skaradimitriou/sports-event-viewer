package com.stathis.sportseventviewer.abstraction

import androidx.recyclerview.widget.DiffUtil
import com.stathis.sportseventviewer.models.LocalModel

class DiffUtilClass<T : LocalModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equalsContent(newItem)
    }
}