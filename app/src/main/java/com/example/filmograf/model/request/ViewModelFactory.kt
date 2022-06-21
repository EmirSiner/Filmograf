package com.example.filmograf.model.request

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.filmograf.network.MovieGet

class ViewModelFactory {
    class ViewmodelProviderFactory(private val movieGet: MovieGet) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RMMovie(movieGet) as T
        }
    }
}