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
    suspend fun getStreaming(): List<MovieItemViewState>
    suspend fun getInTheaters(): List<MovieItemViewState>
    suspend fun getOnTv(): List<MovieItemViewState>
    suspend fun getForRent(): List<MovieItemViewState>

    suspend fun getFreeTV(): List<MovieItemViewState>
    suspend fun getFreeMovies(): List<MovieItemViewState>

    suspend fun getTrendingToday(): List<MovieItemViewState>
    suspend fun getTrendingWeek(): List<MovieItemViewState>


    //suspend fun getMovieDetails(): List<MovieItemViewState>
}

internal class MovieApiImpl : MovieApi {


    override suspend fun getStreaming(): List<MovieItemViewState> {
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

    override suspend fun getOnTv(): List<MovieItemViewState> {
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

    override suspend fun getInTheaters(): List<MovieItemViewState> {
        movieList = listOf(

            MovieItemViewState(
                id = 3,
                title = "Lion King",
                overview = "Lion King",
                imageUrl = R.drawable.lion_king_1x_
            ),
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
            )

        )
        return movieList
    }


    override suspend fun getForRent(): List<MovieItemViewState> {
        movieList = listOf(
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
            ),
            MovieItemViewState(
                id = 2,
                title = "GATTACA",
                overview = "GATTACA",
                imageUrl = R.drawable.gattaca_1x
            )

        )
        return movieList
    }

    override suspend fun getFreeMovies(): List<MovieItemViewState> {
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


    override suspend fun getFreeTV(): List<MovieItemViewState> {
        movieList = listOf(
            MovieItemViewState(
                id = 2,
                title = "GATTACA",
                overview = "GATTACA",
                imageUrl = R.drawable.gattaca_1x
            ), MovieItemViewState(
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


    override suspend fun getTrendingToday(): List<MovieItemViewState> {
        movieList = listOf(
            MovieItemViewState(
                id = 2,
                title = "GATTACA",
                overview = "GATTACA",
                imageUrl = R.drawable.gattaca_1x
            ), MovieItemViewState(
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


    override suspend fun getTrendingWeek(): List<MovieItemViewState> {
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


}