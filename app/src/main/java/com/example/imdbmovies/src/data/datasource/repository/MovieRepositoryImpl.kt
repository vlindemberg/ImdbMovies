package com.example.imdbmovies.src.data.datasource.repository

import com.example.imdbmovies.src.data.datasource.remote.MovieRemote
import com.example.imdbmovies.src.data.datasource.extensions.toListOfMovie
import com.example.imdbmovies.src.domain.model.Movie
import com.example.imdbmovies.src.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor (
    private val remoteDataSource: MovieRemote
) : MovieRepository {
    override fun getMovies(genre: String, year: String): Single<List<Movie>> =
        remoteDataSource.fetch(genre, year).toListOfMovie()
            .onErrorResumeNext { throwable -> Single.error(throwable) }
}