package com.example.tmdb.di

/*
import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieApi
import com.example.tmdb.composables.MovieApiImpl
import com.example.tmdb.screens.FavoriteViewModel
import com.example.tmdb.screens.HomeViewModel
//import com.example.tmdb.screens.HomeViewModel
import com.example.tmdb.screens.MovieRepository
import com.example.tmdb.screens.MovieRepositoryImpl
import org.koin.androidx.compose.get
//import com.example.tmdb.screens.MovieRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val movieAppModule = module {

    val apiModule = module {
        single<MovieApi> {
            MovieApiImpl()
        }
    }

    val movieRepositoryModule = module {
        single<MovieRepository> {
            MovieRepositoryImpl(movieApi = get())
        }
    }
    val homeModule = module {

        viewModel {
            HomeViewModel(MovieRepository = get())
        }
    }
    val favModule = module {
        viewModel {
            FavoriteViewModel(MovieRepository = get())
        }
    }


}*/