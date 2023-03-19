package com.example.imdbmovies.src.presentation.viewmodel

import com.example.imdbmovies.arch.viewmodel.ViewModel
import com.example.imdbmovies.src.domain.usecase.GetMoviesUseCase
import com.example.imdbmovies.src.extensions.applyIOToMainThread

internal class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel<MovieState, MovieAction>(MovieState()) {

    fun getMovies() {
        getMoviesUseCase()
            .applyIOToMainThread()
            .doOnSubscribe { setState { it.copy(isGettingDataLoading = true) } }
            .doAfterTerminate { setState { it.copy(isGettingDataLoading = false) } }
            .subscribe(
                { movies ->
                    sendAction { MovieAction.ShowMovies(movies) }
                },
                { error ->
                    sendAction { MovieAction.ShowErrorMessage(error.message ?: "") }
                }
            ).handleDisposable()
    }
}
