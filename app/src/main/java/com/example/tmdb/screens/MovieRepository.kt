package com.example.tmdb.screens

import com.example.tmdb.composables.MovieApi
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow


interface MovieRepository {

    fun getStreamingMovieList(): Flow<List<MovieItemViewState>>
    fun getFavoriteMovieList(): Flow<List<MovieItemViewState>>
    fun setFavoriteMovieList(Movie: MovieItemViewState)

}

internal class MovieRepositoryImpl(private val MovieApi: MovieApi) : MovieRepository {

    private val streamMovieList: Flow<List<MovieItemViewState>> = flow {
        val streamMovieList = MovieApi.getStreamingMovies()
        emit(streamMovieList)
    }

    private val favoriteMovieList: Flow<List<MovieItemViewState>> = flow {
        val favoriteMovieList = MovieApi.getFavoriteMovies()
        emit(favoriteMovieList)
    }


    override fun getStreamingMovieList(): Flow<List<MovieItemViewState>> {
        return streamMovieList
    }

    private val favoriteMovies = MutableStateFlow(emptyList<MovieItemViewState>())

    override fun getFavoriteMovieList(): Flow<List<MovieItemViewState>> {
        return favoriteMovieList
    }

    override fun setFavoriteMovieList(Movie: MovieItemViewState) {
        val newList: Flow<List<MovieItemViewState>> = this.favoriteMovieList
        val mutableList = favoriteMovies.value.toMutableList()
        mutableList.add(Movie)
        favoriteMovies.value = mutableList.toList()
    }
   //za add i z aremove posebne fje
}

}
