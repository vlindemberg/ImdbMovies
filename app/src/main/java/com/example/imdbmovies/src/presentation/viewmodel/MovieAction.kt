package com.example.imdbmovies.src.presentation.viewmodel

import com.example.imdbmovies.arch.UIAction
import com.example.imdbmovies.src.presentation.model.MovieViewData

internal sealed class MovieAction : UIAction {

    data class ShowMovies(val movies: List<MovieViewData>) : MovieAction()
    data class ShowErrorMessage(val errorMessage: String) : MovieAction()
}