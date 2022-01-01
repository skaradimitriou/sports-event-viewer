package com.stathis.sportseventviewer.ui.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.sportseventviewer.BR
import com.stathis.sportseventviewer.abstraction.AbstractViewHolder
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.SportsModel

class MainChildViewHolder(val binding : ViewDataBinding) : AbstractViewHolder(binding){

    override fun present(data: LocalModel) {
        when(data){
            is SportsModel -> {
                binding.setVariable(BR.model,data)
                //binding.setVariable(BR.callback,callback)
            }
        }
    }
}