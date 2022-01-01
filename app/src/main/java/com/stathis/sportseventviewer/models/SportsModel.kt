package com.stathis.sportseventviewer.models

import com.google.gson.annotations.SerializedName

data class SportsModel(

    @SerializedName("d")
    val d : String,

    @SerializedName("i")
    val eventId : String,

    @SerializedName("si")
    val sportId : String,

    @SerializedName("sh")
    val eventName : String,

    @SerializedName("tt")
    val eventStartTime : Long,

    val isFavorite: Boolean = false

) : LocalModel{
    override fun equalsContent(obj: LocalModel): Boolean {
        return false
    }
}