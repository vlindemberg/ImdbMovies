package com.example.imdbmovies.arch.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.example.imdbmovies.arch.UIAction
import com.example.imdbmovies.arch.UIState

interface LiveDataFactory {

    fun <T: UIState> createMutableLiveData(initialState: T): MutableLiveData<T>

    fun <T: UIAction> createOneShotLiveData(): OneShotLiveData<T>
}
