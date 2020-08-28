package com.alexgabor.sage.core.usecase

import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.repo.RecipeRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class AddRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {

    suspend operator fun invoke(recipe: Recipe): Recipe {
        val id = recipeRepository.insertRecipe(recipe)
        return recipe.copy(id = id)
    }
}