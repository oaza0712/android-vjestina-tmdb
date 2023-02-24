package com.example.tmdb.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.tmdb.composables.MovieItemViewState

sealed class Screen() {
    data class MainScreen(val tab: MainScreenTab) : Screen()
    data class Details (val movie: MovieItemViewState) : Screen()
}

open class MainScreenTab() {
    object HomeTab : MainScreenTab()
    object FavoriteTab : MainScreenTab()
}

object Router {
    var currentScreen: Screen  by mutableStateOf(Screen.MainScreen(MainScreenTab.HomeTab))
    var lastHomeTab: MainScreenTab = (currentScreen as Screen.MainScreen).tab
    var movieR: MovieItemViewState? = null
    fun navigateTo(destination: Screen) {
        when (destination) {

            is Screen.MainScreen -> {
                currentScreen = destination
            }
            is Screen.Details -> {
                lastHomeTab = (currentScreen as Screen.MainScreen).tab
                currentScreen = destination
            }
            else -> throw IllegalStateException("You didnt pass correct screen")
        }
    }
}