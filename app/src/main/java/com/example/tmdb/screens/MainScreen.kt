package com.example.tmdb.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tmdb.R
import com.example.tmdb.screens.Router.lastHomeTab
import com.example.tmdb.ui.theme.Colors

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun MainScreen(mainScreenTab: MainScreenTab) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Colors.Blue500
            )
            {
                Row() {
                    Box() {
                        when (Router.currentScreen) {
                            is Screen.Details -> Image(
                                painter = painterResource(id = R.drawable.back_button_1x),
                                contentDescription = "back button",
                                modifier = Modifier
                                    .padding(15.dp)
                                    .align(
                                        Alignment.Center
                                    )
                                    .clickable { Router.navigateTo(Screen.MainScreen(lastHomeTab)) }
                            
                            else -> throw IllegalStateException("You didnt pass correct screen")
                        }
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
        bottomBar = {
            val selectedIndex = remember { mutableStateOf(1) };
            BottomNavigation(
                elevation = 10.dp,
                backgroundColor = Colors.White100
            ) {

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            "Home",
                            // tint =Colors.Blue700

                        )

                    },
                    label = { Text(text = "Home" /*colors = Colors.Grey200.copy(alpha = 0.6f)*/) },
                    selected = (selectedIndex.value == 1),
                    onClick = {
                        Router.navigateTo(Screen.MainScreen(MainScreenTab.HomeTab))
                        selectedIndex.value = 1
                    },
                    selectedContentColor = Colors.Blue700,
                    unselectedContentColor = Colors.Grey200.copy(alpha = 0.6f)
                )

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            "Favorites",
                            //tint = Colors.Blue700
                        )
                    },
                    label = { Text(text = "Favorite", color = Colors.Blue700) },
                    selected = (selectedIndex.value == 0),
                    onClick = {
                        Router.navigateTo(Screen.MainScreen(MainScreenTab.FavoriteTab))
                        selectedIndex.value = 0
                    }, selectedContentColor = Colors.Blue700,
                    unselectedContentColor = Colors.Grey200.copy(alpha = 0.6f)
                )
            }
        }) {
            paddingValues ->
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding())
          ){}
        Log.i("info", "info");

        if (mainScreenTab == MainScreenTab.HomeTab) {
            HomeScreen()
        } else {
            FavoritesScreen()
        }
    }
}