package com.example.filmograf.network

data class MovieDataResponse(
    val results:List<MovieData>

)
data class MovieData(
        val poster_path: String,
        val overview: String,
        val release_date:String
)
