package com.example.imdbmovies.src.presentation.viewmodel.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.imdbmovies.databinding.ActivityMoviesBinding
import com.example.imdbmovies.src.presentation.model.MovieViewData
import com.example.imdbmovies.src.presentation.onAction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupObservers()
        viewModel.getMovies()
    }

    private fun setupObservers() {
        onAction(viewModel) { action ->
            when (action) {
                is MovieAction.ShowMovies -> loadMoviesList(action.movies)
                is MovieAction.ShowErrorMessage -> loadError(action.errorMessage)
            }
        }
//        onStateChange(viewModel) { viewState ->
//            setupLoading(viewState.isLoading)
//        }
    }

//    private fun setupLoading(loading: Boolean) {
//        if (loading) {
//
//        } else {
//
//        }
//    }

    private fun loadError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun loadMoviesList(movies: List<MovieViewData>) {
        val adapter = MovieAdapter(movies)
        binding.moviesCarouselRecyclerView.adapter = adapter
        binding.moviesCarouselRecyclerView.set3DItem(true)
        binding.moviesCarouselRecyclerView.setAlpha(true)
        binding.moviesCarouselRecyclerView.setInfinite(true)
    }
}
