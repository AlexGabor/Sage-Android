package com.alexgabor.sage.core.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RecipeDao {

    @Transaction
    @Query("SELECT * from recipes")
    fun getRecipes(): Flow<List<RecipeWithIngredientsAndSteps>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(vararg recipeEntity: RecipeEntity): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIngredient(vararg ingredientEntity: IngredientEntity): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStep(vararg stepEntity: StepEntity): List<Long>
}