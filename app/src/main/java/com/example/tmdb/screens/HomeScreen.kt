package com.example.tmdb.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import org.koin.androidx.compose.koinViewModel

import org.koin.androidx.compose.viewModel

var movies =
    listOf(
        MovieItemViewState(
            id = 1,
            title = "Iron Man 1",
            overview = "Iron Man1",
            imageUrl = R.drawable.iron_man_1_1x,
            //favorite = true
        ),
        MovieItemViewState(
            id = 2,
            title = "GATTACA",
            overview = "GATTACA",
            imageUrl = R.drawable.gattaca_1x,
            //favorite = true
        ),
        MovieItemViewState(
            id = 3,
            title = "Lion King",
            overview = "Lion King",
            imageUrl = R.drawable.lion_king_1x_,
            //favorite = false
        ),
        MovieItemViewState(
            id = 1,
            title = "Iron Man 1",
            overview = "Iron Man1",
            imageUrl = R.drawable.godzilla_1x,
            // favorite = false
        ),
        MovieItemViewState(
            id = 2,
            title = "GATTACA",
            overview = "GATTACA",
            imageUrl = R.drawable.jungle_beat_1x_,
            //favorite = false
        )
    )
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TmdbTheme() {
        //HomeScreen();
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val homeViewModel by ViewModel<HomeViewModel>()
    val scaffoldState: ScaffoldState = rememberScaffoldState()



    Scaffold(scaffoldState = scaffoldState)
    {paddingValues ->
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding())
        ){}
        LazyColumn(Modifier.fillMaxSize()) {

            //Searchbar
            item {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Colors.Grey100)
                        .clip(RoundedCornerShape(2.dp))
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

            //Main text
            item {
                Text(
                    text = "What's popular",

                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(top = 15.dp, bottom = 10.dp)
                )
            }

            //Small Text
            item {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Popular",
                        color = Colors.Blue700,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight(800),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .clickable {
                                //homeViewModel.selected = Popular.STREAMING
                            }
                    )
                    Text(
                        text = "Top rated",
                        color = Colors.Blue700,
                        fontWeight = FontWeight(300),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                            .padding(bottom = 10.dp)
                            .clickable {
                                //homeViewModel.selected = Popular.ON_TV
                            }
                    )

                }
            }

            //Movie List
            item {
                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details(it)) },
                    movieItems = movies,
                )
            }

            //Main Text
            item {
                Text(
                    text = "Now playing",
                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(top = 15.dp, bottom = 10.dp)
                )
            }


            //Movie List
            item {

                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details(it)) },
                    movieItems = movies,
                )
            }

            //Main text
            item {
                Text(
                    text = "Upcoming",
                    color = Colors.Blue700,
                    fontWeight = FontWeight(800),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(top = 15.dp, bottom = 10.dp)
                )
            }

            //Movie List
            item {
                MoviesList(
                    modifier = Modifier,
                    onMovieItemClick = { Router.navigateTo(Screen.Details(it)) },
                    movieItems =movies,
                )
            }
        }
    }
}
