package com.example.tmdb.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.R
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.ui.theme.MoviesList
import com.example.tmdb.ui.theme.TmdbTheme

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TmdbTheme() {
        HomeScreen();
    }
}

@Composable
fun HomeScreen() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState)
    { padding->
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Colors.Grey100)
                        .clip(RoundedCornerShape(2.dp))
                    //.border(width = 3.dp, brush =Brush.linearGradient() , shape = RoundedCornerShape(5.dp))

                )
                {
                    IconButton(onClick = { })
                    {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search icon",
                            modifier = Modifier
                                .background(Colors.Grey100)
                                .clip(RoundedCornerShape(30.dp))
                        )
                    }
                    var textState by remember {
                        mutableStateOf("Search")
                    }
                    BasicTextField(
                        value = textState,
                        onValueChange = {
                            textState = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Colors.Grey100)
                            .clip(RoundedCornerShape(30.dp))
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
            }
            //Main text
            item {
                Text(
                    text = "What's popular",

                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Small Text
            item {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Streaming",
                        color = Colors.Blue700,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight(800),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = "On TV",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = "For Rent",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = "In theathers",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }

            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Movie List
            item {
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
                            )
                        )
                    )
                }
                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details) },
                    movieItems = movieList,
                )
            }

            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
            }
            //Main Text
            item {
                Text(
                    text = "Free to watch",
                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Small text
            item {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Movies",
                        textDecoration = TextDecoration.Underline,
                        color = Colors.Blue700,
                        fontWeight = FontWeight(800),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = "TV",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }

            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Movie List
            item {
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
                            )
                        )
                    )
                }
                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details) },
                    movieItems = movieList,
                )
            }

            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
            }
            //Main text
            item {
                Text(
                    text = "Trending",
                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Small text
            item {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Today",
                        textDecoration = TextDecoration.Underline,
                        color = Colors.Blue700,
                        fontWeight = FontWeight(800),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = "This week",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }

            }
            //Spacer
            item {
                Spacer(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }
            //Movie List
            item {
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
                            )
                        )
                    )
                }
                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details) },
                    movieItems = movieList,
                )
            }
        }

    }
}
