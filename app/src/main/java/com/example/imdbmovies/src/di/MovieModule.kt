package com.example.imdbmovies.src.di

import com.example.imdbmovies.src.data.datasource.remote.MovieRemote
import com.example.imdbmovies.src.data.datasource.remote.impl.MovieRemoteImpl
import com.example.imdbmovies.src.data.datasource.remote.service.MovieService
import com.example.imdbmovies.src.data.datasource.repository.MovieRepositoryImpl
import com.example.imdbmovies.src.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface MovieModule {
    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    fun bindMovieRemote(movieRemoteImpl: MovieRemoteImpl): MovieRemote
}

@Module
@InstallIn(SingletonComponent::class)
object MovieNetworkingModule {
    @Provides
    fun providesMovieService(retrofit: Retrofit) : MovieService{
        return retrofit.create()
    }
}