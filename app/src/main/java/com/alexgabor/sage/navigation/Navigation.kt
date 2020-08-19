package com.alexgabor.sage.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigation @Inject constructor() {

    private val _navigationEvent = MutableStateFlow<Screen>(Screen.MyRecipes)
    val navigationEvent: StateFlow<Screen> = _navigationEvent

    fun navigate(screen: Screen) {
        _navigationEvent.value = screen
    }

    sealed class Screen {
        object MyRecipes : Screen()
        object AddRecipe : Screen()
    }
}
