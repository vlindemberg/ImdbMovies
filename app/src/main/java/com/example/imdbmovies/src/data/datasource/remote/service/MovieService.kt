package com.example.imdbmovies.src.data.datasource.remote.service

import com.example.imdbmovies.BuildConfig
import com.example.imdbmovies.src.data.datasource.remote.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {
    @Headers(
        "X-RapidAPI-Key:${BuildConfig.KEY}",
        "X-RapidAPI-Host:${BuildConfig.HOST}"
    )
    @GET("titles/")
    fun getMovies(
        @Query("titleType") type: String = "movie",
        @Query("genre") genre: String,
        @Query("year") year: String,
        ): Single<MovieResponse>
}
