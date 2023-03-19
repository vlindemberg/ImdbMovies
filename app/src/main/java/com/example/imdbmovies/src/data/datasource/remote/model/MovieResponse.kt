package com.example.imdbmovies.src.data.datasource.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: Long,
    @SerializedName("score") val score: Long,
    @SerializedName("score_average") val scoreAverage: Long,
    @SerializedName("type") val type: String,
    @SerializedName("imdbid") val imdbid: String,
    @SerializedName("tmdbid") val tmdbid: Long,
    @SerializedName("traktid") val traktid: Long,
) : Parcelable
