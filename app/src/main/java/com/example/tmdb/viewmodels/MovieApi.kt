package com.example.tmdb.viewmodels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.tmdb.R
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.screens.Router
import com.example.tmdb.screens.Screen
import com.example.tmdb.ui.theme.MoviesList
import kotlinx.coroutines.flow.Flow

interface MovieApi {
    suspend fun getPopularMovies(): List<MovieItemViewState>
    suspend fun getTopRatedMovies(): List<MovieItemViewState>


}

internal class MovieApiImpl : MovieApi {

    var movieList = emptyList<MovieItemViewState>()


    override suspend fun getTopRatedMovies(): List<MovieItemViewState> {
        movieList = listOf(
            MovieItemViewState(
                id = 1,
                title = "Iron Man 1",
                overview = "Iron Man1",
                imageUrl = R.drawable.iron_man_1_1x
            ),
            MovieItemViewState(
                id = 2,
                title = "GATTACA",
                overview = "GATTACA",
                imageUrl = R.drawable.gattaca_1x
            ),
            MovieItemViewState(
                id = 3,
                title = "Lion King",
                overview = "Lion King",
                imageUrl = R.drawable.lion_king_1x_
            )
        )
        return movieList
    }

    override suspend fun getPopularMovies(): List<MovieItemViewState> {
        movieList = listOf(

            MovieItemViewState(
                id = 2,
                title = "GATTACA",
                overview = "GATTACA",
                imageUrl = R.drawable.gattaca_1x
            ),
            MovieItemViewState(
                id = 1,
                title = "Iron Man 1",
                overview = "Iron Man1",
                imageUrl = R.drawable.iron_man_1_1x
            ),
            MovieItemViewState(
                id = 3,
                title = "Lion King",
                overview = "Lion King",
                imageUrl = R.drawable.lion_king_1x_
            )
        )
        return movieList
    }
}