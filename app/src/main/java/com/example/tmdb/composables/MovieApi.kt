package com.example.tmdb.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.tmdb.R
import com.example.tmdb.screens.Router
import com.example.tmdb.screens.Screen
import com.example.tmdb.screens.movieList
import com.example.tmdb.ui.theme.MoviesList
import kotlinx.coroutines.flow.Flow

interface MovieApi {
    suspend fun getStreamingMovies(): List<MovieItemViewState>
    suspend fun getFavoriteMovies(): List<MovieItemViewState>
}

internal class MovieApiImpl : MovieApi {


    override suspend fun getStreamingMovies(): List<MovieItemViewState> {
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

    override suspend fun getFavoriteMovies(): List<MovieItemViewState> {
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

   // override suspend fun setFavoriteMovies(Movie):
}