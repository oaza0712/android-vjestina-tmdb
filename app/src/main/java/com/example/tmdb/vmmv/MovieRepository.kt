package com.example.tmdb.screens

import com.example.tmdb.composables.MovieApi
import com.example.tmdb.composables.MovieItemViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow


interface MovieRepository {

    fun getStreaming(): Flow<List<MovieItemViewState>>
    fun getOnTv(): Flow<List<MovieItemViewState>>
    fun getInTheaters(): Flow<List<MovieItemViewState>>
    fun getForRent(): Flow<List<MovieItemViewState>>

    fun getFreeTV(): Flow<List<MovieItemViewState>>
    fun getFreeMovies(): Flow<List<MovieItemViewState>>

    fun getTrendingToday(): Flow<List<MovieItemViewState>>
    fun getTrendingWeek(): Flow<List<MovieItemViewState>>

   // fun getFavoriteMovieList(): Flow<List<MovieItemViewState>>
   // fun setFavoriteMovieList(Movie: MovieItemViewState)

    fun FlowMaker(select: Popular): Flow<List<MovieItemViewState>>
}

internal class MovieRepositoryImpl(private val MovieApi: MovieApi) : MovieRepository {

    override fun getStreaming(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.STREAMING)
    }
    override fun getOnTv(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.ON_TV)
    }
    override fun getInTheaters(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.IN_THEATHERS)
    }
    override fun getForRent(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.FOR_RENT)
    }
    override fun getFreeMovies(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.FREE_MOVIES)
    }
    override fun getFreeTV(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.FREE_TV)
    }
    override fun getTrendingToday(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.TRENDING_TODAY)
    }
    override fun getTrendingWeek(): Flow<List<MovieItemViewState>> {
        return FlowMaker(Popular.TRENDING_WEEK)
    }

    override fun FlowMaker(select: Popular): Flow<List<MovieItemViewState>> = flow {
        when(select){
            Popular.STREAMING -> emit(MovieApi.getStreaming())
            Popular.ON_TV ->  emit(MovieApi.getOnTv())
            Popular.FOR_RENT ->  emit(MovieApi.getForRent())
            Popular.IN_THEATHERS ->  emit(MovieApi.getInTheaters())
            Popular.FREE_MOVIES ->  emit(MovieApi.getFreeMovies())
            Popular.FREE_TV ->  emit(MovieApi.getFreeTV())
            Popular.TRENDING_TODAY -> emit(MovieApi.getTrendingToday())
            Popular.TRENDING_WEEK -> emit(MovieApi.getTrendingWeek())
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

}

