package com.alexgabor.sage.core.repo

import com.alexgabor.sage.core.model.Ingredient
import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.model.Step
import com.alexgabor.sage.core.source.local.*
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject internal constructor(private val recipeDao: RecipeDao) {

    suspend fun insertRecipe(recipe: Recipe): Long {
        val recipeIds = recipeDao.insertRecipe(recipe.toRecipeEntity())[0].let { recipeId ->
            val ingredients = recipe.ingredients.mapIndexed { index, it -> it.toIngredientEntity(recipeId, index) }.toTypedArray()
            val steps = recipe.steps.mapIndexed { index, it -> it.toStepEntity(recipeId, index) }.toTypedArray()

            recipeDao.insertIngredient(*ingredients)
            recipeDao.insertStep(*steps)
        }
        return recipeIds[0]
    }

    fun getRecipes() = recipeDao.getRecipes().map { list ->
        list.map { it.toRecipe() }
    }
}

private fun Recipe.toRecipeEntity() = RecipeEntity(id, title)

private fun Ingredient.toIngredientEntity(recipeId: Long, index: Int) = IngredientEntity(id, recipeId, index, text)

private fun Step.toStepEntity(recipeId: Long, index: Int) = StepEntity(id, recipeId, index, text)

private fun RecipeWithIngredientsAndSteps.toRecipe() = Recipe(
    recipeEntity.recipeId, recipeEntity.title,
    ingredients.toIngredients(),
    steps.toSteps()
)

private fun List<IngredientEntity>.toIngredients() = this.sortedBy { it.position }.map { it.toIngredient() }

private fun IngredientEntity.toIngredient() = Ingredient(ingredientId, text)

private fun List<StepEntity>.toSteps() = this.sortedBy { it.index }.map { it.toStep() }

private fun StepEntity.toStep() = Step(stepId, text)