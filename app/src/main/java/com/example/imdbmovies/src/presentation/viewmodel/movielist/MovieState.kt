package com.example.imdbmovies.src.presentation.viewmodel.movielist

import com.example.imdbmovies.arch.UIState

data class MovieState(
    val isLoading: Boolean = false,
) : UIState
