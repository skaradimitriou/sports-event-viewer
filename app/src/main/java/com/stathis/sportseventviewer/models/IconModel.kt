package com.stathis.sportseventviewer.models

data class IconModel(
    val title : String,
    val imageUrl : String
) : LocalModel {
    override fun equalsContent(obj: LocalModel): Boolean = when(obj){
        is IconModel -> obj.title == title && obj.imageUrl == imageUrl
        else -> false
    }
}
