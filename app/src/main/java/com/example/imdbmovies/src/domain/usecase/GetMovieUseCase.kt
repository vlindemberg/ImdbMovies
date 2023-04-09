package com.example.imdbmovies.src.domain.usecase

import com.example.imdbmovies.src.domain.repository.MovieRepository
import com.example.imdbmovies.src.domain.extensions.toMovieViewData
import com.example.imdbmovies.src.presentation.model.MovieViewData
import io.reactivex.Single
import javax.inject.Inject

internal class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(genre: String, year: String): Single<List<MovieViewData>> {
        return movieRepository.getMovies(genre, year).toMovieViewData()
    }
}
