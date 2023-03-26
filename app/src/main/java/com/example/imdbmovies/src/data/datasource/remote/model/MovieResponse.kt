package com.example.imdbmovies.src.data.datasource.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results") val data: List<MovieDataResponse>,
) : Parcelable

@Parcelize
data class MovieDataResponse(
    @SerializedName("id") val id: String,
    @SerializedName("primaryImage") val primaryImage: PrimaryImageResponse?,
    @SerializedName("titleText") val titleText: TitleTextResponse?,
    @SerializedName("releaseYear") val releaseYear: ReleaseYearResponse?,
) : Parcelable

@Parcelize
data class PrimaryImageResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("caption") val caption: CaptionResponse?,
) : Parcelable

@Parcelize
data class CaptionResponse(
    @SerializedName("plainText") val altText: String?,
) : Parcelable

@Parcelize
data class TitleTextResponse(
    @SerializedName("text") val text: String?,
) : Parcelable

@Parcelize
data class ReleaseYearResponse(
    @SerializedName("year") val year: Long?,
    @SerializedName("endYear") val endYear: Long?,
) : Parcelable
