package com.example.imdbmovies.src.data.datasource.remote.impl

import com.example.imdbmovies.BuildConfig
import com.example.imdbmovies.src.data.datasource.remote.MovieRemote
import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import com.example.imdbmovies.src.data.datasource.remote.service.MovieService
import io.reactivex.Single

class MovieRemoteImpl(
    private val service: MovieService
) : MovieRemote {

    override fun fetch(): Single<List<MovieResponse>> =
        service.getMovies(BuildConfig.KEY, BuildConfig.HOST)
}
