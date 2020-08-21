package com.alexgabor.sage.screen.addrecipe

import com.alexgabor.sage.arch.Controller
import com.alexgabor.sage.core.AddRecipeUseCase
import com.alexgabor.sage.core.model.Recipe
import com.alexgabor.sage.navigation.Navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddRecipeController @Inject constructor(
    private val navigation: Navigation,
    private val addRecipe: AddRecipeUseCase,
) : Controller() {

    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title

    private val _ingredients = MutableStateFlow(listOf(""))
    val ingredients: StateFlow<List<String>> = _ingredients

    private val _steps = MutableStateFlow(listOf(""))
    val steps: StateFlow<List<String>> = _steps

    fun onTitleChange(value: String) {
        _title.value = value
    }

    fun onAddIngredient() {
        _ingredients.value = _ingredients.value.toMutableList().apply {
            add("")
        }
    }

    fun onAddStep() {
        _steps.value = _steps.value.toMutableList().apply {
            add("")
        }
    }

    fun onIngredientChange(index: Int, value: String) {
        _ingredients.value = _ingredients.value.toMutableList().apply {
            this[index] = value
        }
    }

    fun onStepChange(index: Int, value: String) {
        _steps.value = _steps.value.toMutableList().apply {
            this[index] = value
        }
    }

    fun onSubmit() {
        controllerScope.launch {
            addRecipe(Recipe(
                title = title.value,
                ingredients = ingredients.value,
                steps = ingredients.value
            ))
            navigation.navigate(Navigation.Screen.MyRecipes)
        }
    }
}
