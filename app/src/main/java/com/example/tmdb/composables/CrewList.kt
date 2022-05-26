package com.example.tmdb.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmdb.R
import com.example.tmdb.screens.Router
import com.example.tmdb.screens.Screen

import com.example.tmdb.ui.theme.TmdbTheme


@Preview
@Composable
fun CrewPreview() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    /*Scaffold(scaffoldState = scaffoldState) {
        TmdbTheme() {
            CrewList(
                crewItems = listOf(
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    ),
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    ),
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    ),
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    ),
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    ),
                    CrewItemViewState(
                        name = "Jon Favreau",
                        job = "Director",
                    )
                )
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CrewList(
    crewItems: List<CrewItemViewState>

) {

    Column() {
        var crewSubLists = crewItems.chunked(3)
        for (subList: List<CrewItemViewState> in crewSubLists) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            ) {

                for (item: CrewItemViewState in subList) {
                    CrewCard(
                        modifier = Modifier,
                        item = item
                    )
                }
            }
        }

    }*/
}
