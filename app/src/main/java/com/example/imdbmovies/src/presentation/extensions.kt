package com.example.imdbmovies.src.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.imdbmovies.arch.UIAction
import com.example.imdbmovies.arch.UIState
import com.example.imdbmovies.arch.viewmodel.ViewModel

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onAction(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.action.observe(this, Observer { event -> handleEvents(event as Action) })
}

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onStateChange(
    viewModel: ViewModel<State, Action>,
    crossinline handleStates: (State) -> Unit
) {
    viewModel.state.observe(this, Observer { event -> handleStates(event as State) })
}

