package com.example.tmdb.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Screen() {
    data class MainScreen(val tab: MainScreenTab) : Screen()
    object Details : Screen()
}

open class MainScreenTab() {
    object HomeTab : MainScreenTab()
    object FavoriteTab : MainScreenTab()
}

object Router {
    var currentScreen: Screen by mutableStateOf(Screen.MainScreen(MainScreenTab.HomeTab))
    var lastHomeTab: MainScreenTab = (currentScreen as Screen.MainScreen).tab
    fun navigateTo(destination: Screen) {
        lastHomeTab = (currentScreen as Screen.MainScreen).tab
        currentScreen = destination
    }
}