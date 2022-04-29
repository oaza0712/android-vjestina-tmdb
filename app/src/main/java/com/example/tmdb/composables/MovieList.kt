package com.example.tmdb.ui.theme

import android.icu.util.TimeUnit.values
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion.values
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
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
        items(movieItems) {
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
        var movieList by remember {
            mutableStateOf(
                listOf(
                    MovieItemViewState(
                        id = 1,
                        title = "Iron Man 1",
                        overview = "Iron Man1",
                        imageUrl = "R.drawable.iron_man_1_1X"
                    ),
                    MovieItemViewState(
                        id = 2,
                        title = "GATTACA",
                        overview = "GATTACA",
                        imageUrl = "R.drawable.gattaca_1X"
                    ),
                    MovieItemViewState(
                        id = 3,
                        title = "Lion King",
                        overview = "Lion King",
                        imageUrl = "R.drawable.lion_king_1X"
                    ),
                    MovieItemViewState(
                        id = 3,
                        title = "Lion King",
                        overview = "Lion King",
                        imageUrl = "R.drawable.lion_king_1X"
                    )
                )
            )
        }
        MoviesList(
            modifier = Modifier,
            onMovieItemClick = { },
            movieItems = movieList,
        )
    }
}
