    package com.example.filmograf.di

    import com.example.filmograf.model.request.RMMovie
    import com.example.filmograf.network.MovieData
    import org.koin.androidx.viewmodel.dsl.viewModel
    import org.koin.core.scope.get
    import org.koin.dsl.module
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory


    val networkModule = module {

            viewModel { RMMovie(get()) }

    single {
       Retrofit.Builder()
           .baseUrl("https://api.themoviedb.org/3/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()

   }
        single {
            get<Retrofit>().create(MovieData::class.java)
        }

    }


