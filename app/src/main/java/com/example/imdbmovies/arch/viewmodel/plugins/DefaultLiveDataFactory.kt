package com.example.imdbmovies.arch.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.example.imdbmovies.arch.UIAction
import com.example.imdbmovies.arch.UIState

class DefaultLiveDataFactory : LiveDataFactory {

    override fun <T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T> {
        return MutableLiveData(initialState)
    }

    override fun <T : UIAction> createOneShotLiveData() = OneShotLiveData<T>()
}