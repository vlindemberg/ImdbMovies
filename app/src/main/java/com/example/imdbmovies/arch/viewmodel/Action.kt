package com.example.imdbmovies.arch.viewmodel

import androidx.lifecycle.LiveData
import com.example.imdbmovies.arch.UIAction
import com.example.imdbmovies.arch.viewmodel.plugins.OneShotLiveData
import com.example.imdbmovies.arch.viewmodel.plugins.ViewModelPlugins

class Action<Action : UIAction> {

    private val _action: OneShotLiveData<Action> = ViewModelPlugins.factory.createOneShotLiveData()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}
