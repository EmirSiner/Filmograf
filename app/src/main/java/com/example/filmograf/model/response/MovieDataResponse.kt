package com.example.filmograf.model.response

    data class MovieResponse(
val results:List<MovieResult>
)

data class MovieResult(
    val id: Int,
    val name: String,
    val poster_path: String
){
    val imageUrl: String
    get() = "https://image.tmdb.org/t/p/w500$poster_path"
}


