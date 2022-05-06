package com.example.tmdb.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.R
import com.example.tmdb.composables.ActorItemViewState
import com.example.tmdb.composables.ActorList
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.composables.StarButton
import com.example.tmdb.screens.Router.currentScreen
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.ui.theme.FavoriteButton
import com.example.tmdb.ui.theme.MoviesList
import com.example.tmdb.ui.theme.TmdbTheme
@Preview
@Composable
fun DetailsPreview(){
    Scaffold() {
        TmdbTheme {
            DetailsScreen()
        }
    }
}

@Preview
@Composable
fun DetailsScreen() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Colors.Blue500
            )
            {
                Row() {
                    Box() {
                        Image(
                            painter = painterResource(id = R.drawable.back_button_1x),
                            contentDescription = "back button",
                            modifier = Modifier
                                .padding(15.dp)
                                .align(
                                    Alignment.Center
                                )
                                .clickable { Router.navigateTo(Screen.MainScreen(Router.lastHomeTab)) }
                        )

                    }

                    Image(
                        painter = painterResource(id = R.drawable.tmdb),
                        contentDescription = "TMDB App Bar",
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .wrapContentWidth(align = Alignment.CenterHorizontally)
                            .padding(8.dp)
                            .scale(3F)
                    )
                }

            }
        },
    ) {
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                ) {
            //Picture
            Header()
            Overview()
            Details_1()
            Actors()
            BackPressHandler(onBackPressed = { Router.navigateTo(Screen.MainScreen(Router.lastHomeTab)) })
        }
    }
}

@Composable
private fun ColumnScope.Actors() {
    //Actor List

    Row() {
        Text(
            text = "Top Billed Cast",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 20.dp, bottom = 20.dp)
        )
        Text(
            textAlign = TextAlign.Right,
            text = "Full cast & crew",
            color = Colors.Blue700,
            fontWeight = FontWeight(400),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 20.dp, bottom = 20.dp),
        )
    }

    //Movie List
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
@Composable
private fun ColumnScope.Details_1() {
    //Small Text

    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Don Heck",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Text(
            text = "Jack Kirby",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Text(
            text = "John Favreau",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
    }



    //Small Text

    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Characters",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Characters",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Director",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
    }



    //Small Text

    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Don Heck",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Jack Marcum",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Matt Holloway",
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
    }



    //Small Text

    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Screenplay",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Screenplay",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
        Text(
            text = "Screenplay",
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 10.dp)
        )
    }



}
@Composable
private fun ColumnScope.Overview() {
    //Main text

    Text(
        text = "Overview",
        color = Colors.Blue700,
        fontWeight = FontWeight(800),
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp)
    )

    //Text
    Text(
        text = stringResource(id = R.string.overview_text) /*"After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil."*/,
        color = Colors.Blue700,
        fontWeight = FontWeight(300),
        fontSize = 15.sp,
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 10.dp, bottom = 10.dp)
    )

}

@Composable
private fun ColumnScope.Header(){
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.56f)
            .background(color = Colors.Grey200)
    ) {
        Image(
            painter = painterResource(id = R.drawable.iron_man_1_1x),
            contentDescription = "Top picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Column(
            Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomStart)
                .padding(15.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Box() {
                    CircularProgressIndicator(progress = 0.75f, color = Colors.Green100)
                    Text(
                        text = "75%",
                        modifier = Modifier.align(alignment = Alignment.Center),
                        color = Colors.White100,
                        fontSize = 13.sp
                    )

                }
                Text(
                    text = "User Score",
                    modifier = Modifier.padding(5.dp),
                    color = Colors.White100,
                    fontSize = 20.sp
                )
            }

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Iron Man",
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(top = 10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(800),
                    color = Colors.White100
                )
                Text(
                    text = "2008",
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(top = 10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Colors.White100
                )
            }

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "05/02/2008 (US)",
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(top = 5.dp),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(400),
                    color = Colors.White100
                )
            }

            Row(Modifier.fillMaxWidth()) {
                Text(
                    text = "Action, Science Fiction, Adventure  ",
                    color = Colors.White100,
                    modifier = Modifier
                        .padding(0.dp)
                        .padding(top = 3.dp, bottom = 10.dp),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = "2h 6m",
                    color = Colors.White100,
                    modifier = Modifier
                        .padding(0.dp)
                        .padding(top = 3.dp, bottom = 10.dp),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(800)
                )
            }

            StarButton(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.button_position),
                    top = dimensionResource(id = R.dimen.button_position)
                )
            )
        }}
}