package com.example.imdbmovies.src.presentation.model

data class MovieViewData(
    val id: String,
    val imgUrl: String,
    val imgAlt: String,
    val title: String,
    val year: Long,
    val endYear: Long,
)
