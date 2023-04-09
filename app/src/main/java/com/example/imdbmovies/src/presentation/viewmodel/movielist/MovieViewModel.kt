package com.example.imdbmovies.src.presentation.viewmodel.movielist

import com.example.imdbmovies.arch.viewmodel.ViewModel
import com.example.imdbmovies.src.domain.usecase.GetMoviesUseCase
import com.example.imdbmovies.src.domain.extensions.applyIOToMainThread
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel<MovieState, MovieAction>(MovieState()) {

    fun getMovies(genre: String, year: String) {
        getMoviesUseCase(genre, year)
            .applyIOToMainThread()
            .doOnSubscribe { setState { it.copy(isLoading = true) } }
            .doAfterTerminate { setState { it.copy(isLoading = false) } }
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
