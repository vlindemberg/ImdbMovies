package com.example.imdbmovies.arch.viewmodel

import com.example.imdbmovies.arch.UIState

abstract class StateViewModel<State : UIState>(initialState: State) : DisposableViewModel() {

    private val stateAttribute = State(initialState)

    fun getState() = stateAttribute.state

    fun setState(state: (State) -> State) {
        stateAttribute.setState(state)
    }
}
