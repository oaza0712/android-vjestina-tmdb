package com.example.tmdb.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmdb.R
import com.example.tmdb.ui.theme.Colors.Blue700

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onClicked: (Boolean) -> Unit = {},
) {
    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite),
        contentDescription = "Favorite Button",
        modifier = modifier
            .clickable {
                onClicked.invoke(!isFavorite)
            }
            .size(dimensionResource(id = R.dimen.button_size))
            .background(Colors.Blue700.copy(alpha = 0.6f), CircleShape)
            .padding(dimensionResource(id = R.dimen.small_spacing)),
        contentScale = ContentScale.FillBounds
    )
}

@Preview(showBackground = true)
@Composable
fun Favourite_buttonPreview() {
    TmdbTheme() {
        FavoriteButton();
    }
}
