package com.alexgabor.sage.di

import com.alexgabor.sage.arch.Controller
import com.alexgabor.sage.screen.NavigatorController
import com.alexgabor.sage.screen.addrecipe.AddRecipeController
import com.alexgabor.sage.screen.recipedetail.RecipeDetailController
import com.alexgabor.sage.screen.recipelist.RecipeListController
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ControllerModule {

    @Binds
    @IntoMap
    @ControllerKey(NavigatorController::class)
    fun provideNavigatorController(navigatorController: NavigatorController): Controller

    @Binds
    @IntoMap
    @ControllerKey(AddRecipeController::class)
    fun provideAddRecipeController(addRecipeController: AddRecipeController): Controller

    @Binds
    @IntoMap
    @ControllerKey(RecipeListController::class)
    fun provideRecipeListController(recipeListController: RecipeListController): Controller

    @Binds
    @IntoMap
    @ControllerKey(RecipeDetailController::class)
    fun provideRecipeDetailController(recipeDetailController: RecipeDetailController): Controller
}