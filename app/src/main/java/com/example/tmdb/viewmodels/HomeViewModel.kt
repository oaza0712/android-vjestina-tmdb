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
class HomeViewModel(private val MovieRepository: MovieRepository) : ViewModel() {

    val popularMovies = MutableStateFlow<List<MovieItemViewState>>(emptyList())

    init {
        viewModelScope.launch {
            (MovieRepository.getPopular(selected=Popular.STREAMING)).collect {
                popularMovies.value = it
            }
        }
    }


    var selected: Popular = Popular.STREAMING

}

// 3 flow-a

// private val streamingMovies: Flow<List<MovieItemViewState>> =
//   MovieRepository.getStreamingMovieList()

//nad repo pozovi add ili remove za favorite

fun selectWhatsPopular(index: Int) {

}


enum class Popular {
    STREAMING, ON_TV, FOR_RENT, IN_THEATHERS
}
enum class Free{
    FREE_MOVIES, FREE_TV
}
enum class Trending{
    TRENDING_TODAY, TRENDING_WEEK
}