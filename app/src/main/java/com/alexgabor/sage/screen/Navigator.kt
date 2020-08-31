package com.alexgabor.sage.screen

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alexgabor.sage.arch.controller
import com.alexgabor.sage.navigation.Navigation
import com.alexgabor.sage.screen.addrecipe.AddRecipeScreen
import com.alexgabor.sage.screen.recipedetail.RecipeDetailScreen
import com.alexgabor.sage.screen.recipelist.RecipeListScreen

@Composable
fun Navigator() {
    val controller by controller { navigatorController }
    val screen by controller.navigationEvent.collectAsState()

    Crossfade(screen) { currentScreen ->
        Screen(currentScreen)
    }
}

@Composable
fun Screen(state: Navigation.Screen) {
    when (state) {
        Navigation.Screen.MyRecipes -> RecipeListScreen()
        Navigation.Screen.AddRecipe -> AddRecipeScreen()
        is Navigation.Screen.RecipeDetail -> RecipeDetailScreen(state.recipe)
    }
}
