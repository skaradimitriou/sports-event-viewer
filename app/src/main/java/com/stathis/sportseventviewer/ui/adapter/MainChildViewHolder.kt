package com.stathis.sportseventviewer.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeSportsItemBinding
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.SportsModel
import com.stathis.sportseventviewer.util.TimeHelper

class MainChildViewHolder(val binding : HolderHomeSportsItemBinding,val callback : SportsClickListener) : RecyclerView.ViewHolder(binding.root){


    fun present(data: LocalModel) {
        when(data){
            is SportsModel -> {
                val time = TimeHelper.convertToTime(data.eventStartTime)

                //FIXME: Implement countdown on each item

                binding.time = time
                binding.model = data
                binding.callback = callback
            }
        }
    }
}