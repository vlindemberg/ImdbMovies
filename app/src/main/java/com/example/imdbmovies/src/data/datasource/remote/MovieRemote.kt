package com.example.imdbmovies.src.data.datasource.remote

import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import io.reactivex.Single

interface MovieRemote {
    fun fetch(genre: String, year: String): Single<MovieResponse>
}