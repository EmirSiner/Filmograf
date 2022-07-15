package com.example.filmograf.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmograf.model.response.MovieDetailResponse
import com.example.filmograf.network.MovieService
import kotlinx.coroutines.launch

class MovieDetailVM(private val movieService: MovieService):ViewModel() {
    private val _movieLiveDataLiveData = MutableLiveData<MovieDetailResponse>()
    val movieLiveData: LiveData<MovieDetailResponse> = _movieLiveDataLiveData


    fun fetchMovieDetail(movieId: Int ){
        viewModelScope.launch {
            val movieDetailResponse= movieService.getMovieDetail(movieId.toString(),"217de4d3febec492285dbe5fada73b5d")
            _movieLiveDataLiveData.value = movieDetailResponse
        }

    }
}