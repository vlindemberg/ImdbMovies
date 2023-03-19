package com.example.imdbmovies.src.domain.model

data class Movie(
    val id: String,
    val title: String,
    val year: Long,
    val score: Long,
    val scoreAverage: Long,
    val type: String,
)
