package com.alexgabor.sage.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun SageTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}