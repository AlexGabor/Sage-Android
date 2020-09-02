package com.alexgabor.sage.di

import com.alexgabor.sage.arch.ControllerStore
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [
    ControllerModule::class
])
interface ControllerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ControllerComponent
    }

    val controllerStore: ControllerStore
}