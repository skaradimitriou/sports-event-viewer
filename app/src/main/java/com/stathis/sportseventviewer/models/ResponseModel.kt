package com.stathis.sportseventviewer.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("i")
    val sportId : String,

    @SerializedName("d")
    val sportName : String,

    @SerializedName("e")
    val events : List<SportsModel>,

    var isExpandable: Boolean = true

) : LocalModel{
    override fun equalsContent(obj: LocalModel): Boolean = when(obj){
        is ResponseModel -> obj.sportId == sportId && sportName == sportName && obj.events == events && obj.isExpandable == isExpandable
        else -> false
    }
}