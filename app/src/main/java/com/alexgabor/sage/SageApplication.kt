package com.alexgabor.sage


import android.app.Application
import com.alexgabor.sage.di.AppComponent
import com.alexgabor.sage.di.ControllerComponent
import com.alexgabor.sage.di.DaggerAppComponent

class SageApplication : Application() {

    init {
        app = this
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    val controllerComponent: ControllerComponent by lazy {
        appComponent.controllerComponent().create()
    }

    companion object {
        lateinit var app: SageApplication
    }
}