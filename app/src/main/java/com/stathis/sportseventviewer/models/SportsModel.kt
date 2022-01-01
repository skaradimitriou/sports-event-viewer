package com.stathis.sportseventviewer.models

data class SportsModel(

    val d : String,
    val i : String,
    val si : String,
    val sh : String,
    val tt : Int

) : LocalModel{
    override fun equalsContent(obj: LocalModel): Boolean {
        return false
    }
}