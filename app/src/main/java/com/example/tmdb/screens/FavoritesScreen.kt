package com.example.tmdb.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.screens.movieList as movieList
import androidx.compose.foundation.lazy.items
import com.example.tmdb.composables.MovieCard

var movieList =
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
        )
    )


@ExperimentalFoundationApi
@Preview
@Composable
fun FavoritesScreen() {
    val scaffoldStateMain: ScaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldStateMain) { padding->
        Column(Modifier.fillMaxSize()) {

            Spacer(
                Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Favorites",
                color = Colors.Blue700,
                fontWeight = FontWeight(800),
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
            Spacer(
                Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(movieList) { item ->
                    Box(Modifier.padding(bottom = 10.dp)) {
                        MovieCard(
                            item = item,
                            onMovieItemClick = { Router.navigateTo(Screen.Details) },
                            isFavorite = true
                        )
                    }
                }
            }

        }

    }
    BackPressHandler(onBackPressed = { Router.navigateTo(Screen.MainScreen(MainScreenTab.HomeTab)) })
}
