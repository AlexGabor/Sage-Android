package com.alexgabor.sage.di

import com.alexgabor.sage.screen.NavigatorController
import com.alexgabor.sage.screen.addrecipe.AddRecipeController
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [AssistedModule::class])
interface ControllerComponent {
    val navigatorController: NavigatorController
    val addRecipeController: AddRecipeController
}