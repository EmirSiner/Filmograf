package com.example.filmograf.network

import retrofit2.http.GET

interface MovieGet {
    @GET("movie")
    suspend fun fetchCharacters(): MovieDataResponse

}