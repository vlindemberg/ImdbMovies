package com.example.imdbmovies.src.data.datasource.extensions

import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import com.example.imdbmovies.src.domain.model.Movie
import io.reactivex.Single

fun Single<List<MovieResponse>>.toListOfMovie(): Single<List<Movie>> =
    this.map { movies ->
        movies.map { movie ->
            Movie(
                id = movie.id,
                title = movie.title,
                year = movie.year,
                score = movie.score,
                scoreAverage = movie.scoreAverage,
                type = movie.type
            )
        }
    }
