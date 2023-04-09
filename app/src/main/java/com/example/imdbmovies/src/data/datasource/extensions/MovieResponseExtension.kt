package com.example.imdbmovies.src.data.datasource.extensions

import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import com.example.imdbmovies.src.domain.model.Movie
import io.reactivex.Single

fun Single<MovieResponse>.toListOfMovie(): Single<List<Movie>> =
    this.map { movies ->
        movies.data.map { movie ->
            Movie(
                id = movie.id,
                imgUrl = movie.primaryImage?.url ?: "",
                imgAlt = movie.primaryImage?.caption?.altText ?: "",
                title = movie.titleText?.text ?: "",
                year = movie.releaseYear?.year.toString(),
                endYear = movie.releaseYear?.endYear.toString()
            )
        }
    }

