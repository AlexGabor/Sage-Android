package com.alexgabor.sage.screen

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.alexgabor.sage.arch.controller
import com.alexgabor.sage.navigation.Navigation

@Composable
fun Navigator() {
    val controller by controller { navigatorController }
    val screen by controller.navigationEvent.collectAsState()

    Screen(screen)
}

@Composable
fun Screen(state: Navigation.Screen) {
    when (state) {
        Navigation.Screen.MyRecipes -> Text(text = "MyRecipes")
        Navigation.Screen.AddRecipe -> Text(text = "AddRecipe")
    }
}
