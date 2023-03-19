package com.example.imdbmovies.src.data.datasource.repository

import com.example.imdbmovies.src.data.datasource.remote.MovieRemote
import com.example.imdbmovies.src.data.datasource.extensions.toListOfMovie
import com.example.imdbmovies.src.domain.model.Movie
import com.example.imdbmovies.src.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(
    private val remoteDataSource: MovieRemote
) : MovieRepository {
    override fun getMovies(): Single<List<Movie>> =
        remoteDataSource.fetch().toListOfMovie()
            .onErrorResumeNext { throwable -> Single.error(throwable) }
}