package com.example.imdbmovies.src.presentation.model

data class MovieViewData(
    val id: String,
    val title: String,
    val year: Long,
    val score: Long,
    val scoreAverage: Long,
    val type: String,
)
