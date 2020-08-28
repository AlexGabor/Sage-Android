package com.alexgabor.sage.di

import android.content.Context
import com.alexgabor.sage.core.dagger.CoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AssistedModule::class,
        AppModule::class,
        CoreModule::class,
    ],
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun controllerComponent(): ControllerComponent.Factory
}