package com.example.tmdb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.composables.MovieItemViewState
import com.example.tmdb.screens.*
import com.example.tmdb.ui.theme.*
import com.example.tmdb.ui.theme.Colors
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.InvocationTargetException


class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        try {
            super.onCreate(savedInstanceState)
            setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val currentScreen: Screen = Router.currentScreen
                    when (currentScreen) {
                        is Screen.MainScreen -> {
                            val tab: MainScreenTab = currentScreen.tab
                            MainScreen(mainScreenTab = tab)
                        }
                        is Screen.Details -> {
                            val movieData: MovieItemViewState = currentScreen.movie
                            ScreenDetails(movie = movieData)
                        }
                    }
                }
            }
        } catch (e : InvocationTargetException) {

            // Answer:
            e.cause;
        } catch ( e: InvocationTargetException) {

            // generic exception handling
            e.printStackTrace();
        }
    }
}