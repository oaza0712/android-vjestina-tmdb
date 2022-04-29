package com.example.tmdb.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmdb.R
import com.example.tmdb.ui.theme.TmdbTheme

@Composable
fun ActorList(
    modifier: Modifier = Modifier,
    onActorItemClick: (ActorItemViewState) -> Unit = {},
    actorItems: List<ActorItemViewState>
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.home_movies_list_content_padding))
    ) {
        items(actorItems) {
            ActorCard(
                modifier = Modifier.padding(horizontal = 5.dp),
                item = it,
                onActorItemClick = { onActorItemClick(it) }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ActorListPreview() {
    TmdbTheme() {
        var actorList by remember {
            mutableStateOf(
                listOf(
                    ActorItemViewState(
                        id = 1,
                        name = "Robert Downey Jr.",
                        role = "Tony Stark/Iron Man",
                        imageUrl = "R.drawable.iron_man_1_1x"
                    ),
                    ActorItemViewState(
                        id = 1,
                        name = "Robert Downey Jr.",
                        role = "Tony Stark/Iron Man",
                        imageUrl = "R.drawable.iron_man_1_1x"
                    ),
                    ActorItemViewState(
                        id = 1,
                        name = "Robert Downey Jr.",
                        role = "Tony Stark/Iron Man",
                        imageUrl = "R.drawable.iron_man_1_1x"
                    ),
                    ActorItemViewState(
                        id = 1,
                        name = "Robert Downey Jr.",
                        role = "Tony Stark/Iron Man",
                        imageUrl = "R.drawable.iron_man_1_1x"
                    )
                )
            )
        }
        ActorList(
            modifier = Modifier,
            onActorItemClick = { },
            actorItems = actorList,
        )
    }
}
