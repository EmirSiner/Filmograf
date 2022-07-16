package com.example.filmograf.network


import com.example.filmograf.model.response.MovieDetailResponse
import com.example.filmograf.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    suspend fun fetchCharacters(@Query("api_key") apiKey:String): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId:String,
        @Query("api_key") apiKey:String
    ):MovieDetailResponse
}