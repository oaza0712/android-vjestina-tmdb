package com.example.tmdb.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.R
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.ui.theme.FavoriteButton
import com.example.tmdb.ui.theme.TmdbTheme

data class ActorItemViewState(
    val id: Int,
    val name: String,
    val role: String,
    val imageUrl: String
)

@Composable
fun ActorCard(
    modifier: Modifier = Modifier,
    onActorItemClick: () -> Unit = {},
    item: ActorItemViewState
) {
    Column(
        modifier = modifier
            .clickable { onActorItemClick() }
            .width(122.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.rdj_1x_),
            contentDescription = null,
            modifier = Modifier
                .size(
                    width = dimensionResource(id = R.dimen.movie_card_width),
                    height = 120.dp
                )
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.small_spacing))),
            contentScale = ContentScale.FillBounds
        )
        Spacer(
            Modifier
                .height(5.dp)
        )
        Text(
            text = item.name,
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 5.dp),
        )
        Spacer(
            Modifier
                .height(5.dp)
        )
        Text(
            text = item.role,
            color = Colors.Grey200,
            fontWeight = FontWeight(400),
            fontSize = 15.sp,
            modifier = Modifier.padding(start = 5.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActorCardPreview() {
    TmdbTheme() {
        ActorCard(
            modifier = Modifier,
            item = ActorItemViewState(
                id = 1,
                name = "Robert Downey Jr.",
                role = "Tony Stark/Iron Man",
                imageUrl = "R.drawable.iron_man_1_1x"
            )
        )
    }
}