package com.example.tmdb.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class HomeViewModel(private val MovieRepository: MovieRepository) : ViewModel() {

    private val selectedPopularList = MutableStateFlow(0)

    val popularList = selectedPopularList.flatMapLatest{
        when(it) {
           0 -> MovieRepository.getStreamingMovieList()
           1 ->
        }
    }

    private val streamingMovies: Flow<List<MovieItemViewState>> =
        MovieRepository.getStreamingMovieList()

    @JvmName("getStreamingMovies1")
        fun getStreamingMovies(): Flow<List<MovieItemViewState>> {
        return streamingMovies
    }
    //nad repo pozovi add ili remove za favorite

    fun selectWhatsPopular(index:Int) {

    }
}

