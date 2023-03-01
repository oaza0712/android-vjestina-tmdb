package com.example.tmdb.repository

import android.graphics.Movie
import com.example.tmdb.composables.MovieApi
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.viewmodels.Popular
import kotlinx.coroutines.flow.*

import kotlinx.coroutines.selects.select

// tu wrapas u flow

interface MovieRepository {
    fun getPopularMovies(): Flow<List<MovieItemViewState>>
}

internal class MovieRepositoryImpl(private val movieApi: MovieApi) : MovieRepository {

    override fun getPopularMovies(): Flow<List<MovieItemViewState>> = popularMovies
     private val popularMovies = getPopularMovieFlow(MovieCategory.PopularMovies)
    private fun getPopularMovieFlow(selected: MovieCategory) : Flow<List<MovieItemViewState>> = flow {
        when (selected) {
            MovieCategory.PopularMovies -> emit(movieApi.getStreaming());
            MovieCategory.TopRatedMovies -> emit(movieApi.getForRent());
        }
    }

    sealed class MovieCategory {
        object PopularMovies : MovieCategory()
        object TopRatedMovies : MovieCategory()
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


