package com.example.tmdb.screens

import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(private val MovieRepository: MovieRepository): ViewModel() {
    private val favoriteMovies: Flow<List<MovieItemViewState>> =
        MovieRepository.getFavoriteMovieList()

    @JvmName("getFavoriteMovies1")
    fun getFavoriteMovies(): Flow<List<MovieItemViewState>> {
        return favoriteMovies
    }

   fun addFavoriteMovies(Movie: MovieItemViewState){
       MovieRepository.setFavoriteMovieList(Movie)
   }
}