package com.alexgabor.sage.screen.recipelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import androidx.ui.tooling.preview.PreviewParameterProvider
import com.alexgabor.sage.arch.controller
import com.alexgabor.sage.core.model.Ingredient
import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.core.model.Step

@Composable
fun RecipeListScreen() {
    val controller = controller<RecipeListController>()
    val recipes by controller.recipes.collectAsState(initial = listOf())

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { controller.onAdd() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(Icons.Outlined.Add, "Add")
            }
        }
        LazyColumn {
            items(items = recipes, itemContent = { recipe ->
                RecipeItem(recipe, onClick = { controller.onRecipeClick(recipe) })
            })
        }
    }
}

@Preview
@Composable
fun RecipeItem(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe, onClick: () -> Unit = { }) {
    ListItem(Modifier.clickable(onClick = onClick)) {
        Text(recipe.title)
    }
}

class RecipePreviewProvider : PreviewParameterProvider<Recipe> {
    override val values: Sequence<Recipe>
        get() = sequenceOf(
            Recipe(title = "Pancakes",
                ingredients = listOf(Ingredient(1, "1 Egg"), Ingredient(2, "1 cup of flour")),
                steps = listOf(Step(1, "Add all of them")))
        )

}