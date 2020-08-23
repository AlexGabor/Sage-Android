package com.alexgabor.sage.screen.recipelist

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.IconButton
import androidx.compose.material.ListItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alexgabor.sage.arch.controller
import com.alexgabor.sage.core.model.Recipe

@Composable
fun RecipeListScreen() {
    val controller by controller { recipeListController }
    val recipes by controller.recipes.collectAsState(initial = listOf())

    Column {
        Stack(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { controller.onAdd() }, modifier = Modifier.gravity(Alignment.CenterEnd)) {
                Icon(asset = Icons.Outlined.Add)
            }
        }
        LazyColumnFor(items = recipes) { recipe ->
            RecipeItem(recipe, onClick = { controller.onRecipeClick(recipe) })
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit = { }) {
    ListItem(Modifier.clickable(onClick = onClick)) {
        Text(recipe.title)
    }
}