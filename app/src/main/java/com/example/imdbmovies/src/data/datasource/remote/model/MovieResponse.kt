package com.example.imdbmovies.src.data.datasource.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("id") private val id: String,
    @SerializedName("title") private val title: String,
    @SerializedName("year") private val year: Long,
    @SerializedName("score") private val score: Long,
    @SerializedName("score_average") private val scoreAverage: Long,
    @SerializedName("type") private val type: String,
    @SerializedName("imdbid") private val imdbid: String,
    @SerializedName("tmdbid") private val tmdbid: Long,
    @SerializedName("traktid") private val traktid: Long,
) : Parcelable
