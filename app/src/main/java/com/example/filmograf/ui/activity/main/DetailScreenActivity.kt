package com.example.filmograf.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.filmograf.R
import com.example.filmograf.model.request.RmItemAdapter

import com.example.filmograf.model.response.MovieResult
import com.example.filmograf.viewmodel.MovieDetailVM
import com.example.filmograf.viewmodel.RMMovie
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailScreenActivity : AppCompatActivity() {
    private val movieViewModel: MovieDetailVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        val movieId = intent.getIntExtra("movie_id",0)

        val iwMovie=  findViewById<ImageView>(R.id.iwDetailScreen)
        val twMovie =findViewById<TextView>(R.id.twDetailScreen)
        movieViewModel.fetchMovieDetail(movieId)
        movieViewModel.movieLiveData.observe(this) { movieDetail ->

        twMovie.text = movieDetail.title
        Glide.with(iwMovie).load(movieDetail.imageUrl).into(iwMovie)
}}




 /*   fun aaaa(
//movieResult: MovieResult,
)
    {
    val iwMovie=findViewById<ImageView>(R.id.iwDetailScreen)
    val twMovie=findViewById<TextView>(R.id.twDetailScreen)
    twMovie.text = movieResult.name
    Glide.with(iwMovie).load(movieResult.imageUrl).into(iwMovie)


}
*/

}


