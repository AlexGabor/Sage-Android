package com.alexgabor.sage.core

import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.source.InMemoryRecipes
import dagger.Reusable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Reusable
class GetRecipesUseCase @Inject constructor(
    private val recipeRepository: InMemoryRecipes,
) {

    operator fun invoke(): Flow<List<Recipe>> {
        return recipeRepository.recipes
    }
}