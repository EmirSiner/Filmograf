package com.example.filmograf.model.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmograf.network.MovieData
import com.example.filmograf.network.MovieDataResponse
import com.example.filmograf.network.MovieGet
import kotlinx.coroutines.launch

class RMMovie(val movieGet: MovieGet):ViewModel() {
    private val _movieLiveDataLiveData = MutableLiveData<List<MovieData>>()
    val characterLiveData : MutableLiveData<List<MovieData>> = _movieLiveDataLiveData

    init {
        viewModelScope.launch {
            val movieData =  movieGet.fetchCharacters()
            _movieLiveDataLiveData.value = movieData.results
        }
    }
}