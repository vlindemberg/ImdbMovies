package com.example.imdbmovies.src.domain.repository

import com.example.imdbmovies.src.domain.model.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(): Single<List<Movie>>
}
