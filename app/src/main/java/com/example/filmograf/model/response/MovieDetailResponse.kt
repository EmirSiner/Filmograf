package com.example.filmograf.model.response

data class MovieDetailResponse(
    val original_title:String,
    val poster_path:String,
    val overview:String,
    val title:String,
    val tagline:String
)
{
    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w500$poster_path"
}