package com.example.filmograf.di

import com.example.filmograf.viewmodel.RMMovie
import com.example.filmograf.network.MovieService
import com.example.filmograf.viewmodel.MovieDetailVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {


    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    single {
        get<Retrofit>().create(MovieService::class.java)
    }

}
val viewModelModule = module {

    viewModel { RMMovie(get()) }
    viewModel { MovieDetailVM(get()) }
}

