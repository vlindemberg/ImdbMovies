package com.example.imdbmovies.src.data.datasource.remote.impl

import com.example.imdbmovies.BuildConfig
import com.example.imdbmovies.src.data.datasource.remote.MovieRemote
import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import com.example.imdbmovies.src.data.datasource.remote.service.MovieService
import io.reactivex.Single
import javax.inject.Inject

class MovieRemoteImpl @Inject constructor(
    private val service: MovieService
) : MovieRemote {

    override fun fetch(): Single<MovieResponse> =
        service.getMovies()
}
