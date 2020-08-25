package com.alexgabor.sage.di

import android.content.Context
import androidx.room.Room
import com.alexgabor.sage.core.source.local.RecipeDao
import com.alexgabor.sage.core.source.local.RecipeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DbModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): RecipeDatabase = Room.databaseBuilder(context, RecipeDatabase::class.java, "RecipeDatabase").build()

    @Singleton
    @Provides
    fun provideRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao = recipeDatabase.recipeDao()
}