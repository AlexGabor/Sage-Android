package com.alexgabor.sage.screen.addrecipe

import androidx.compose.foundation.Icon
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Stack
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.ui.tooling.preview.Preview
import com.alexgabor.sage.arch.controller

@Preview
@Composable
fun AddRecipeScreen() {
    val controller by controller { addRecipeController }
    val title by controller.title.collectAsState()
    val ingredients by controller.ingredients.collectAsState()
    val steps by controller.steps.collectAsState()

    Column {
        Stack(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { controller.onSubmit() }, modifier = Modifier.gravity(Alignment.CenterEnd)) {
                Icon(asset = Icons.Outlined.Done)
            }
        }
        ScrollableColumn(modifier = Modifier.fillMaxSize()) {
            TextField(value = title, onValueChange = { controller.onTitleChange(it) }, label = { Text(text = "Title") })

            Button(onClick = {}) { Text(text = "Add cover") }

            ingredients.forEachIndexed { index, text ->
                TextField(value = text, onValueChange = { controller.onIngredientChange(index, it) }, label = { Text(text = "Ingredient") })
            }
            Button(onClick = { controller.onAddIngredient() }) { Text(text = "Add ingredient") }

            steps.forEachIndexed { index, text ->
                TextField(value = text, onValueChange = { controller.onStepChange(index, it) }, label = { Text(text = "Step") })
            }
            Button(onClick = { controller.onAddStep() }) { Text(text = "Add step") }
        }
    }
}