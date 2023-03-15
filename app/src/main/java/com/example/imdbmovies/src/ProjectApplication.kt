package com.example.imdbmovies.src

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProjectApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startModules()
    }

    private fun startModules() {
        startKoin {
            androidContext(this@ProjectApplication)
            modules()
        }
    }
}
