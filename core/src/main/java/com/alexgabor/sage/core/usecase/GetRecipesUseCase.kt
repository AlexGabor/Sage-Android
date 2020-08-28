package com.alexgabor.sage.core.usecase

import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.repo.RecipeRepository
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {

    operator fun invoke(): Flow<List<Recipe>> {
        return recipeRepository.getRecipes()
    }
}