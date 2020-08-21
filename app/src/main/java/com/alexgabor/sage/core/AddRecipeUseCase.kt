package com.alexgabor.sage.core

import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.source.InMemoryRecipes
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AddRecipeUseCase @Inject constructor(
    private val recipeRepository: InMemoryRecipes,
) {

    suspend operator fun invoke(recipe: Recipe): Recipe {
        return recipeRepository.add(recipe)
    }
}