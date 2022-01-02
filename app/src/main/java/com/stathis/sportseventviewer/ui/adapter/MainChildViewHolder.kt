package com.stathis.sportseventviewer.ui.adapter


import android.os.CountDownTimer
import androidx.recyclerview.widget.RecyclerView
import com.stathis.sportseventviewer.callback.SportsClickListener
import com.stathis.sportseventviewer.databinding.HolderHomeSportsItemBinding
import com.stathis.sportseventviewer.models.LocalModel
import com.stathis.sportseventviewer.models.SportsModel
import com.stathis.sportseventviewer.util.TimeHelper


class MainChildViewHolder(
    val binding: HolderHomeSportsItemBinding,
    val callback: SportsClickListener
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var myTimer : CountDownTimer
    var timeLeft = 0L

    /*
    FIXME: Ask for a better solution for the timer
     */

    fun present(data: LocalModel) {
        when (data) {
            is SportsModel -> {
                val time = TimeHelper.convertToTime(data.eventStartTime)

                timeLeft = data.eventStartTime

                myTimer = object : CountDownTimer(timeLeft,1000){
                    override fun onTick(secondsLeft: Long) {
                        timeLeft = secondsLeft

                        val time = TimeHelper.convertToTime(timeLeft)

                        binding.time = time
                    }

                    override fun onFinish() {
                    }
                }.start()

                binding.time = time
                binding.model = data
                binding.callback = callback
            }
        }
    }
}