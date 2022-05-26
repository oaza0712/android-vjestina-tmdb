package com.example.tmdb.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.tmdb.composables.*
import com.example.tmdb.screens.Router.currentScreen
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.ui.theme.FavoriteButton
import com.example.tmdb.ui.theme.MoviesList
import com.example.tmdb.ui.theme.TmdbTheme
import org.w3c.dom.Text

var actorList =
    listOf(
        ActorItemViewState(
            id = 1,
            name = "Robert Downey Jr.",
            role = "Tony Stark/Iron Man",
            imageUrl = R.drawable.rdj_1x_
        ),
        ActorItemViewState(
            id = 1,
            name = "Robert Downey Jr.",
            role = "Tony Stark/Iron Man",
            imageUrl = R.drawable.terrence_howard_1x_
        ),
        ActorItemViewState(
            id = 1,
            name = "Robert Downey Jr.",
            role = "Tony Stark/Iron Man",
            imageUrl = R.drawable.terrence_howard_1x_
        ),
        ActorItemViewState(
            id = 1,
            name = "Robert Downey Jr.",
            role = "Tony Stark/Iron Man",
            imageUrl = R.drawable.rdj_1x_
        )
    )
var crewList = listOf(
    CrewItemViewState(
        name = "Don Heck",
        job = "Characters",
    ),
    CrewItemViewState(
        name = "Jon Kirby",
        job = "Characters",
    ),
    CrewItemViewState(
        name = "Jon Favreau",
        job = "Director",
    ),
    CrewItemViewState(
        name = "Don Heck",
        job = "Screenplay",
    ),
    CrewItemViewState(
        name = "Jack Marcum",
        job = "Screnplay",
    ),
    CrewItemViewState(
        name = "Matt Holloway",
        job = "Screnplay",
    )
)

@Preview
@Composable
fun DetailsPreview() {
    Scaffold() {
        TmdbTheme {
            DetailsContent(overview = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
                progress = "75%",
                movieTitle = "Iron Man",
                year = "2008",
                releaseDate = "05/02/2008 (US)",
                genre = "Action, Science Fiction, Adventure",
                duration = "2h 6m",
                crewList =  crewList,
                actorList = actorList)
        }
    }
}


@Composable
fun DetailsContent(
    overview: String,
    progress: String,
    movieTitle: String,
    year: String,
    releaseDate: String,
    genre: String,
    duration: String,
    crewList: List<CrewItemViewState>,
    actorList: List<ActorItemViewState>
) {
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
            Header(progress, movieTitle, year, releaseDate, genre, duration)
            Overview(overview)
            Crew(crewList)
            Actors(actorList)
            BackPressHandler(onBackPressed = { Router.navigateTo(Screen.MainScreen(Router.lastHomeTab)) })
        }
    }
}

@Composable
fun ScreenDetails(movie: MovieItemViewState) {
    //predstavlja dohvaćanje podataka o filmu kroz API

    DetailsContent(
        overview = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
        progress = "75%",
        movieTitle = movie.title,
        year = "2008",
        releaseDate = "05/02/2008 (US)",
        genre = "Action, Science Fiction, Adventure",
        duration = "2h 6m",
        crewList=crewList,
        actorList = actorList
    )
}

@Composable
private fun ColumnScope.Actors(actorList: List<ActorItemViewState>) {

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

    ActorList(
        modifier = Modifier,
        onActorItemClick = { },
        actorItems = actorList,
    )
}

@Composable
private fun ColumnScope.Crew(crewList: List<CrewItemViewState>) {
    //CrewList(crewItems = crewList)
}

@Composable
private fun ColumnScope.Overview(overview: String) {

    Text(
        text = "Overview",
        color = Colors.Blue700,
        fontWeight = FontWeight(800),
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp)
    )

    Text(
        text = overview,
        color = Colors.Blue700,
        fontWeight = FontWeight(300),
        fontSize = 15.sp,
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .padding(top = 10.dp, bottom = 20.dp)
    )
}

@Composable
private fun ColumnScope.Header(
    progress: String,
    movieTitle: String,
    year: String,
    releaseDate: String,
    genre: String,
    duration: String
) {
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
                        text = progress,
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
                    text = movieTitle,
                    modifier = Modifier
                        .padding(5.dp)
                        .padding(top = 10.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight(800),
                    color = Colors.White100
                )
                Text(
                    text = year,
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
                    text = releaseDate,
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
                    text = genre,
                    color = Colors.White100,
                    modifier = Modifier
                        .padding(0.dp)
                        .padding(top = 3.dp, bottom = 10.dp),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(400)
                )
                Text(
                    text = duration,
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
        }
    }
}