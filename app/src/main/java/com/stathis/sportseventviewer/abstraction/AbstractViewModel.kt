package com.stathis.sportseventviewer.abstraction

import android.app.Application
import androidx.lifecycle.AndroidViewModel

abstract class AbstractViewModel(app : Application) : AndroidViewModel(app) {

    fun getString(id : Int) = getApplication<Application>().resources.getString(id)
}