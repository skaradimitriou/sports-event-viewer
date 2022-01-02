package com.stathis.sportseventviewer.util

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object TimeHelper {

    fun convertToTime(time: Long): String {
        val timestamp = Timestamp(time)
        val date = Date(timestamp.time)

        val dateFormat = SimpleDateFormat("HH:mm:ss").also {
            it.timeZone = TimeZone.getTimeZone("GMT+3")
        }

        return dateFormat.format(date)
    }
}