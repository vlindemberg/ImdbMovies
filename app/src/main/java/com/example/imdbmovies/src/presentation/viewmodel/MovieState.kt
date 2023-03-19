package com.example.imdbmovies.src.presentation.viewmodel

import com.example.imdbmovies.arch.UIState

data class MovieState(
    val isGettingDataLoading: Boolean = false,
) : UIState
