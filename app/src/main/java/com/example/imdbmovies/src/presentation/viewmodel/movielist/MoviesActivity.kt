package com.example.imdbmovies.src.presentation.viewmodel.movielist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.imdbmovies.R
import com.example.imdbmovies.databinding.ActivityMoviesBinding
import com.example.imdbmovies.src.presentation.model.MovieViewData
import com.example.imdbmovies.src.presentation.onAction
import com.example.imdbmovies.src.presentation.onStateChange
import com.example.imdbmovies.src.presentation.viewmodel.movielist.adapter.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMoviesBinding
    private val viewModel: MovieViewModel by viewModels()
    private var gender = ""
    private var year = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupSpinners()
        setupObservers()
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchButton.setOnClickListener {
            viewModel.getMovies(gender, year)
        }
    }

    private fun setupSpinners() {
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.genderSpinner.adapter = adapter
            binding.genderSpinner.onItemSelectedListener = this
        }
        ArrayAdapter.createFromResource(
            this,
            R.array.year_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.yearSpinner.adapter = adapter
            binding.yearSpinner.onItemSelectedListener = this
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovies(gender, year)
    }

    private fun setupObservers() {
        onAction(viewModel) { action ->
            when (action) {
                is MovieAction.ShowMovies -> loadMoviesList(action.movies)
                is MovieAction.ShowErrorMessage -> loadError(action.errorMessage)
            }
        }
        onStateChange(viewModel) { viewState ->
            setupLoading(viewState.isLoading)
        }
    }

    private fun setupLoading(loading: Boolean) {
        if (loading) {
            binding.animationView.visibility = View.VISIBLE
        } else {
            binding.animationView.visibility = View.GONE
        }
    }

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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent?.id == binding.genderSpinner.id) {
            gender = parent.getItemAtPosition(position).toString()
        } else if (parent?.id == binding.yearSpinner.id) {
            year = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //nothing
    }
}