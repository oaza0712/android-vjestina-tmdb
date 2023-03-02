package com.example.tmdb.di


import com.example.tmdb.screens.FavoriteViewModel
import com.example.tmdb.viewmodels.HomeViewModel

import com.example.tmdb.repository.MovieRepository


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieAppModule = module {

    val homeModule = module {

        viewModel {
            HomeViewModel(movieRepository = get())
        }
    }

    /*
    val favModule = module {
        viewModel {
            FavoriteViewModel(MovieRepository = get())
        }
    }*/


}