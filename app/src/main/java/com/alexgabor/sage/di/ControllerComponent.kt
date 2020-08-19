package com.alexgabor.sage.di

import com.alexgabor.sage.screen.NavigatorController
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [AssistedModule::class])
interface ControllerComponent {
    val navigatorController: NavigatorController
}