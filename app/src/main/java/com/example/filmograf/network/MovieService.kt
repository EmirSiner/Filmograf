package com.example.filmograf.network

import retrofit2.http.GET

interface MovieService {
    @GET("character")
    suspend fun fetchCharacters(): MovieData
}