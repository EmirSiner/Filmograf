package com.example.filmograf.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.filmograf.R
import com.example.filmograf.viewmodel.MovieDetailVM
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailScreenActivity : AppCompatActivity() {
    private val movieViewModel: MovieDetailVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        val movieId = intent.getIntExtra("movie_id", 0)

        val iwMovie = findViewById<ImageView>(R.id.iwDetailScreen)
        val twMovie = findViewById<TextView>(R.id.twDetailScreen)
        val twMovieDetail = findViewById<TextView>(R.id.twDetail)
        val twMovieTagLine = findViewById<TextView>(R.id.twTagline)
        movieViewModel.fetchMovieDetail(movieId)
        movieViewModel.movieLiveData.observe(this) { movieDetail ->

            twMovie.text = movieDetail.title
            twMovieDetail.text = movieDetail.overview
            twMovieTagLine.text = movieDetail.tagline
            Glide.with(iwMovie).load(movieDetail.imageUrl).into(iwMovie)
        }
    }


}


