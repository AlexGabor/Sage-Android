package com.alexgabor.sage.screen.recipedetail

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.viewModel
import com.alexgabor.sage.arch.controller
import com.alexgabor.sage.core.model.Recipe

@Composable
fun RecipeDetailScreen(recipe: Recipe) {
    val controller by controller { recipeDetailController }

    Column {
        Text(text = recipe.title)
        recipe.ingredients.forEach { ingredient ->
            Text(text = ingredient.text)
        }
        recipe.steps.forEach { step ->
            Text(text = step.text)
        }
    }
}
