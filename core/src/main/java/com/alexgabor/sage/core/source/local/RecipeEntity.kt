package com.alexgabor.sage.core.source.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "recipes")
internal data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val recipeId: Long = 0,
    val title: String,
)

@Entity(tableName = "ingredients")
internal data class IngredientEntity(
    @PrimaryKey(autoGenerate = true)
    val ingredientId: Long = 0,
    val ingredientRecipeId: Long,
    val position: Int,
    val text: String,
)

@Entity(tableName = "steps")
internal data class StepEntity(
    @PrimaryKey(autoGenerate = true)
    val stepId: Long = 0,
    val stepRecipeId: Long,
    val index: Int,
    val text: String,
)

internal data class RecipeWithIngredientsAndSteps(
    @Embedded val recipeEntity: RecipeEntity,
    @Relation(
        parentColumn = "recipeId",
        entity = IngredientEntity::class,
        entityColumn = "ingredientRecipeId"
    )
    val ingredients: List<IngredientEntity>,
    @Relation(
        parentColumn = "recipeId",
        entity = StepEntity::class,
        entityColumn = "stepRecipeId"
    )
    val steps: List<StepEntity>,
)