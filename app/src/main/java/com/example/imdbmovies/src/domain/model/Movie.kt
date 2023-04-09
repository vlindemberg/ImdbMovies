package com.example.imdbmovies.src.domain.model

data class Movie(
    val id: String,
    val imgUrl: String,
    val imgAlt: String,
    val title: String,
    val year: String,
    val endYear: String,
)
