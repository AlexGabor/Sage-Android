package com.alexgabor.sage.core.model

data class Recipe(
    val id: Long = NO_ID,
    val title: String,
    val ingredients: List<Ingredient>,
    val steps: List<Step>
)

const val NO_ID = 0L