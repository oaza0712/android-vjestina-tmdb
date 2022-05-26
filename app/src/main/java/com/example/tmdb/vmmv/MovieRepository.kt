package com.example.tmdb.screens

import android.graphics.Movie
import com.example.tmdb.composables.MovieApi
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.selects.select

// tu wrapas u flow

interface MovieRepository {
    fun getPopular(selected: Popular): Flow<List<MovieItemViewState>>
}

internal class MovieRepositoryImpl(private val movieApi: MovieApi) : MovieRepository {

    override fun getPopular(selected: Popular) /*:Flow<List<MovieItemViewState>>*/ = flow {
        when (selected) {
            Popular.STREAMING -> emit(movieApi.getStreaming());
            Popular.FOR_RENT -> emit(movieApi.getForRent());
            Popular.IN_THEATHERS -> emit(movieApi.getInTheaters());
            Popular.ON_TV -> emit(movieApi.getOnTv());
        }
    }
}
    /*
    private val favoriteMovies = MutableStateFlow(emptyList<MovieItemViewState>())

    override fun setFavoriteMovieList(Movie: MovieItemViewState) {
        val newList: Flow<List<MovieItemViewState>> = this.favoriteMovieList
        val mutableList = favoriteMovies.value.toMutableList()
        mutableList.add(Movie)
        favoriteMovies.value = mutableList.toList()
    }
    //za add i z aremove posebne fje
}*/

