package com.alexgabor.sage.core.model

data class Recipe(
    val id: Int = NO_ID,
    val title: String,
    val ingredients: List<String>,
    val steps: List<String>
)

const val NO_ID = -1