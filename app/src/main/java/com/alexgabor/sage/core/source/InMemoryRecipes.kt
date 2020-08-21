package com.alexgabor.sage.core.source

import com.alexgabor.sage.core.model.Recipe
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InMemoryRecipes @Inject constructor() {

    private var id = 0

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    internal val recipes: StateFlow<List<Recipe>> = _recipes

    suspend fun add(recipe: Recipe): Recipe {
        delay(200)
        val internalRecipe = recipe.copy(id = id++)
        _recipes.value = _recipes.value.toMutableList().apply {
            add(internalRecipe)
        }
        return internalRecipe
    }
}