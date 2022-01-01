package com.stathis.sportseventviewer.models

data class ResponseModel(

    val i : String,
    val d : String,
    val e : List<SportsModel>

) : LocalModel{
    override fun equalsContent(obj: LocalModel): Boolean {
        return false
    }
}
