package com.stathis.sportseventviewer.ui.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.sportseventviewer.BR
import com.stathis.sportseventviewer.abstraction.AbstractViewHolder
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.SportsModel
import com.stathis.sportseventviewer.util.TimeHelper

class MainChildViewHolder(val binding : ViewDataBinding,val callback : SportsClickListener) : AbstractViewHolder(binding){


    override fun present(data: LocalModel) {
        when(data){
            is SportsModel -> {
                val time = TimeHelper.convertToTime(data.eventStartTime)

                //FIXME: Implement countdown on each item

                binding.setVariable(BR.time,time)
                binding.setVariable(BR.model,data)
                binding.setVariable(BR.callback,callback)
            }
        }
    }
}