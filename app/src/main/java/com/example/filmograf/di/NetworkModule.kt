    package com.example.filmograf.di

    import com.example.filmograf.network.MovieService
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


