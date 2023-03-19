package com.example.imdbmovies.arch.viewmodel

import com.example.imdbmovies.arch.UIAction

abstract class ActionViewModel<Action : UIAction> : DisposableViewModel() {

    private val actionAttribute = Action<Action>()

    fun getAction() = actionAttribute.action

    fun setAction(action: () -> Action) {
        actionAttribute.sendAction(action)
    }
}
