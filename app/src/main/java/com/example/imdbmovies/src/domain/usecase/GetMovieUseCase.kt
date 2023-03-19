package com.example.imdbmovies.src.domain.usecase

import com.example.imdbmovies.src.domain.repository.MovieRepository
import com.example.imdbmovies.src.extensions.toMovieViewData
import com.example.imdbmovies.src.presentation.model.MovieViewData
import io.reactivex.Single

internal class GetMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Single<List<MovieViewData>> {
        return movieRepository.getMovies().toMovieViewData()
    }
}
