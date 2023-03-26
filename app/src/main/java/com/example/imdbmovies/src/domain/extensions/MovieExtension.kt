package com.example.imdbmovies.src.domain.extensions

import com.example.imdbmovies.src.domain.model.Movie
import com.example.imdbmovies.src.presentation.model.MovieViewData
import io.reactivex.Single

fun Single<List<Movie>>.toMovieViewData(): Single<List<MovieViewData>> =
    this.map { movies ->
        movies.map { movie ->
            MovieViewData(
                id = movie.id,
                imgUrl = movie.imgUrl,
                imgAlt = movie.imgAlt,
                title = movie.title,
                year = movie.year,
                endYear = movie.endYear,
            )
        }
    }