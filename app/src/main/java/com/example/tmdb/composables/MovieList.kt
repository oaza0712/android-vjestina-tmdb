package com.example.tmdb.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdb.R
import com.example.tmdb.composables.MovieCard
import com.example.tmdb.composables.MovieItemViewState

@Composable
 fun MoviesList(
    modifier: Modifier = Modifier,
    onMovieItemClick: (MovieItemViewState) -> Unit = {},
    movieItems: List<MovieItemViewState>
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.home_movies_list_content_padding))
    ) {
        this.items(movieItems) {
            MovieCard(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.micro_spacing)),
                item = it,
                onMovieItemClick = { onMovieItemClick(it) }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MoviesListPreview() {
    TmdbTheme() {
       /* var movieList by remember {
            mutableStateOf(
                listOf(
                    MovieItemViewState(
                        id = 1,
                        title = "Iron Man 1",
                        overview = "Iron Man1",
                        imageUrl = R.drawable.iron_man_1_1x,
                        favorite = true
                    ),
                    MovieItemViewState(
                        id = 2,
                        title = "GATTACA",
                        overview = "GATTACA",
                        imageUrl = R.drawable.gattaca_1x,
                        favorite = true
                    ),
                    MovieItemViewState(
                        id = 3,
                        title = "Lion King",
                        overview = "Lion King",
                        imageUrl = R.drawable.lion_king_1x_,
                        favorite = false
                    ),
                    MovieItemViewState(
                        id = 1,
                        title = "Iron Man 1",
                        overview = "Iron Man1",
                        imageUrl = R.drawable.godzilla_1x,
                        favorite = false
                    ),
                    MovieItemViewState(
                        id = 2,
                        title = "GATTACA",
                        overview = "GATTACA",
                        imageUrl = R.drawable.jungle_beat_1x_,
                        favorite = false
                    )
                )
            )
        }
        MoviesList(
            modifier = Modifier,
            onMovieItemClick = { },
            movieItems = movieList,
        )
    }*/
}}
