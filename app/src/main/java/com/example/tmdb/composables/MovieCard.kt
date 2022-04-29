package com.example.tmdb.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdb.R
import com.example.tmdb.ui.theme.FavoriteButton
import com.example.tmdb.ui.theme.TmdbTheme

data class MovieItemViewState(
    val id: Int,
    val title: String,
    val overview: String,
    val imageUrl: String
)

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    onMovieItemClick: () -> Unit = {},
    item: MovieItemViewState,
    isFavorite: Boolean = false
) {
    Box(
        modifier = modifier.clickable { onMovieItemClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.iron_man_1_1x),
            contentDescription = null,
            modifier = Modifier
                .size(
                    width = dimensionResource(id = R.dimen.movie_card_width),
                    height = dimensionResource(id = R.dimen.movie_card_height)
                )
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small_spacing))),
            contentScale = ContentScale.FillBounds
        )
        FavoriteButton(
            modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.button_position),
                top = dimensionResource(id = R.dimen.button_position)

            ), isFavorite = isFavorite
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    TmdbTheme() {
        MovieCard(
            modifier = Modifier,
            item = MovieItemViewState(
                id = 1,
                title = "Iron Man",
                overview = "Iron Man",
                imageUrl = "R.drawable.iron_man_1_1x"
            )
        )
    }
}