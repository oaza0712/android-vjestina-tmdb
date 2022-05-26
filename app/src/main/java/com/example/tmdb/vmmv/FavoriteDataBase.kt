package com.example.tmdb.vmmv

import com.example.tmdb.composables.MovieItemViewState

class FavoriteDataBase {

    var favorites :MutableList<MovieItemViewState> = mutableListOf();

    fun addFavoriteMovie(movie: MovieItemViewState) {
        favorites += movie;
    }
    fun getFavoriteMovie(movie: MovieItemViewState) :MutableList<MovieItemViewState>{
       return favorites;
    }

    fun setFavoriteMovie(movie: MovieItemViewState){
         favorites.remove(movie);
    }
}