package com.example.filmograf.model.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmograf.model.response.MovieResult
import com.example.filmograf.network.MovieService
import kotlinx.coroutines.launch

class RMMovie(private val movieService: MovieService) : ViewModel() {
    private val _movieLiveDataLiveData = MutableLiveData<List<MovieResult>>()
    val movieLiveData: LiveData<List<MovieResult>> = _movieLiveDataLiveData

    init {
        viewModelScope.launch {
            val movieData = movieService.fetchCharacters("217de4d3febec492285dbe5fada73b5d")
            _movieLiveDataLiveData.value = movieData.results
        }
    }
}