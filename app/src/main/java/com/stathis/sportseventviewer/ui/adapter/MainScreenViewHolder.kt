package com.stathis.sportseventviewer.ui.adapter

import androidx.databinding.ViewDataBinding
import com.stathis.sportseventviewer.abstraction.AbstractViewHolder
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.BR
import com.stathis.sportseventviewer.R
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.models.ResponseModel

class MainScreenViewHolder(val binding: ViewDataBinding,val callback : SportsClickListener) : AbstractViewHolder(binding) {

    override fun present(data: LocalModel) {
        when (data) {
            is ResponseModel -> {
                val adapter = MainChildAdapter(callback)
                adapter.submitList(data.events)

                //FIXME: Implement expand & collapse action


//                when(isExpanded){
//                    true -> {
//                        binding.categoryArrow.setImageResource(R.drawable.ic_arrow_facing_up)
//                    }
//                    false -> {
//                        binding.categoryArrow.setImageResource(R.drawable.ic_arrow_facing_down)
//                    }
//                }


                binding.setVariable(BR.adapter, adapter)
                binding.setVariable(BR.model, data)
            }
        }
    }
}