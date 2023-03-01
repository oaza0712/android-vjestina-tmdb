package com.example.tmdb.screens

import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class FavoriteViewModel(private val MovieRepository: MovieRepository): ViewModel() {
    private val favoriteMovies: Flow<List<MovieItemViewState>> =
        emptyFlow()

    @JvmName("getFavoriteMovies1")
    fun getFavoriteMovies(): Flow<List<MovieItemViewState>> {
        return favoriteMovies
    }

   fun addFavoriteMovies(Movie: MovieItemViewState){

   }
}