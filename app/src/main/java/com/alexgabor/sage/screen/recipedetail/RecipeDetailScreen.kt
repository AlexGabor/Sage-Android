package com.alexgabor.sage.screen.recipedetail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import com.alexgabor.sage.core.model.Ingredient
import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.model.Step
import com.alexgabor.sage.screen.recipelist.RecipePreviewProvider

@Preview
@Composable
fun RecipeDetailScreen(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe) {
//    val controller by controller { recipeDetailController }

    Column {
        Text(text = recipe.title, style = MaterialTheme.typography.h2)
        recipe.ingredients.forEach { ingredient ->
            IngredientItem(ingredient)
        }
        Spacer(modifier = Modifier.preferredHeight(8.dp))
        recipe.steps.forEachIndexed { index, step ->
            StepItem(index, step)
        }
    }
}

@Composable
private fun StepItem(index: Int, step: Step) {
    Row {
        Text(text = "${index + 1}.", Modifier.padding(8.dp))
        Text(text = step.text, Modifier.padding(8.dp))
    }
}

@Composable
fun IngredientItem(ingredient: Ingredient) {
    Row {
        Text(text = "•", Modifier.padding(8.dp))
        Text(text = ingredient.text, Modifier.padding(8.dp))
    }
}