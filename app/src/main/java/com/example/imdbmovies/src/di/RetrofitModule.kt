package com.example.imdbmovies.src.di

import com.example.imdbmovies.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val RETROFIT = "retrofit"
private const val CLIENT = "client"
private const val GSON = "gson"

val retrofitModule = module {

    single(named(RETROFIT)) {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get(named(CLIENT)))
            .addConverterFactory(GsonConverterFactory.create(get(named(GSON))))
            .build()
    }
}