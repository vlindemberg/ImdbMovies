package com.example.imdbmovies.src.data.datasource.remote.service

import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieService {

    @GET
    fun getMovies(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String
    ): Single<List<MovieResponse>>
}
