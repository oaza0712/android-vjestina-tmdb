package com.example.tmdb.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb.composables.MovieItemViewState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.*

class HomeViewModel(private val MovieRepository: MovieRepository) : ViewModel() {
     var selected :Popular = Popular.STREAMING
     val selectedPopular = MutableStateFlow(selected)
    val popularList = selectedPopular.flatMapLatest{
        when(it) {
            Popular.STREAMING -> MovieRepository.getStreaming()
            Popular.ON_TV -> MovieRepository.getOnTv()
            Popular.FOR_RENT -> MovieRepository.getForRent()
            Popular.IN_THEATHERS -> MovieRepository.getInTheaters()
            Popular.FREE_MOVIES -> TODO()
            Popular.FREE_TV -> TODO()
            Popular.TRENDING_TODAY -> TODO()
            Popular.TRENDING_WEEK -> TODO()
        }
    }
   suspend fun flat() :List<MovieItemViewState> {
       return popularList.flatMapConcat { it.asFlow() }.toList()
   }
   // private val streamingMovies: Flow<List<MovieItemViewState>> =
    //   MovieRepository.getStreamingMovieList()

    //nad repo pozovi add ili remove za favorite

    fun selectWhatsPopular(index:Int) {

    }

}

enum class Popular{
    STREAMING, ON_TV, FOR_RENT, IN_THEATHERS, FREE_MOVIES, FREE_TV, TRENDING_TODAY, TRENDING_WEEK
}