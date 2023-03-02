package com.example.tmdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieItemViewState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.tmdb.R
import com.example.tmdb.repository.MovieRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

///collectaj flow
//
////init get movies
class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val popularMovies = getMovieByCategory(MovieCategory.PopularMovies)

    fun getMovieByCategory(category: MovieCategory): StateFlow<List<MovieItemViewState>> {
        val flow = when (category) {
            is MovieCategory.PopularMovies -> movieRepository.getPopularMovies()
            is MovieCategory.TopRatedMovies -> movieRepository.getTopRatedMovies()
            // is MovieCategory.NowPlayingMovies -> movieRepository.getNowPlayingMovies()
            // is MovieCategory.UpcomingMovies -> movieRepository.getUpcomingMovies()
        }
        return (flow.stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            initialValue = emptyList()
        ))
    }



    sealed class MovieCategory {
        object PopularMovies : MovieCategory()
        object TopRatedMovies : MovieCategory()
    }
}

// 3 flow-a

// private val streamingMovies: Flow<List<MovieItemViewState>> =
//   MovieRepository.getStreamingMovieList()

//nad repo pozovi add ili remove za favorite


