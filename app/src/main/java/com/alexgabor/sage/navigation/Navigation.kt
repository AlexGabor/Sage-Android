package com.alexgabor.sage.navigation

import com.alexgabor.sage.core.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigation @Inject constructor() {

    private val _navigationEvent = MutableStateFlow<Screen>(Screen.MyRecipes)
    val navigationEvent: StateFlow<Screen> = _navigationEvent

    private val stack = mutableListOf<Screen>()

    fun navigate(screen: Screen) {
        stack.add(navigationEvent.value)
        _navigationEvent.value = screen
    }

    fun goBack(): Boolean {
        if (stack.isEmpty()) return false
        _navigationEvent.value = stack.removeLast()
        return true
    }

    sealed class Screen {
        object MyRecipes : Screen()
        object AddRecipe : Screen()
        class RecipeDetail(val recipe: Recipe) : Screen()
    }
}
