package com.stathis.sportseventviewer.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("i")
    val sportId : String,

    @SerializedName("d")
    val sportName : String,

    @SerializedName("e")
    val events : List<SportsModel>

) : LocalModel{
    override fun equalsContent(obj: LocalModel): Boolean {
        return false
    }
}
