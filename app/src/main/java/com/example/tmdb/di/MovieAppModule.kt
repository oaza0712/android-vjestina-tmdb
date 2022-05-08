package com.example.tmdb.di

import androidx.savedstate.ViewTreeSavedStateRegistryOwner
import com.example.tmdb.screens.FavoriteViewModel
//import com.example.tmdb.screens.HomeViewModel
import com.example.tmdb.screens.MovieRepository
//import com.example.tmdb.screens.MovieRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
/*
val movieAppModule = module{
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModel {
        HomeViewModel(get())
    }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModel {
        FavoriteViewModel(get())
    }
}*/