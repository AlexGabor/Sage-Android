package com.alexgabor.sage.screen.recipelist

import com.alexgabor.sage.arch.Controller
import com.alexgabor.sage.core.GetRecipesUseCase
import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.navigation.Navigation
import javax.inject.Inject

class RecipeListController @Inject constructor(
    private val navigation: Navigation,
    getRecipes: GetRecipesUseCase,
): Controller() {

    val recipes = getRecipes()

    fun onAdd() {
        navigation.navigate(Navigation.Screen.AddRecipe)
    }

    fun onRecipeClick(recipe: Recipe) {
        navigation.navigate(Navigation.Screen.RecipeDetail(recipe))
    }
}