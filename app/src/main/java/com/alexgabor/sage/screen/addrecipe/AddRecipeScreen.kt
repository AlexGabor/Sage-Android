package com.alexgabor.sage.screen.addrecipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
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
    val controller = controller<AddRecipeController>()
    val title by controller.title.collectAsState()
    val ingredients by controller.ingredients.collectAsState()
    val steps by controller.steps.collectAsState()

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { controller.onSubmit() }, modifier = Modifier.align(Alignment.CenterEnd)) {
                Icon(Icons.Outlined.Done, "Done")
            }
        }
        rememberScrollState(0f)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                TextField(value = title, onValueChange = { controller.onTitleChange(it) }, label = { Text(text = "Title") })
            }
            item {
                Button(onClick = {}) { Text(text = "Add cover") }
            }
            itemsIndexed(ingredients) { index, text ->
                TextField(value = text, onValueChange = { controller.onIngredientChange(index, it) }, label = { Text(text = "Ingredient") })
            }
            item {
                Button(onClick = { controller.onAddIngredient() }) { Text(text = "Add ingredient") }
            }
            itemsIndexed(steps) { index, text ->
                TextField(value = text, onValueChange = { controller.onStepChange(index, it) }, label = { Text(text = "Step") })
            }
            item {
                Button(onClick = { controller.onAddStep() }) { Text(text = "Add step") }
            }
        }
    }
}