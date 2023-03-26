package com.example.imdbmovies.src.presentation.viewmodel.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbmovies.databinding.CarouselItemBinding
import com.example.imdbmovies.src.presentation.model.MovieViewData

class MovieAdapter(private val movieList: List<MovieViewData>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = CarouselItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.binding.apply {
            Glide.with(movieImage).load(movie.imgUrl).into(movieImage)
            movieName.text = movie.title
        }
    }

    override fun getItemCount(): Int = movieList.size
}