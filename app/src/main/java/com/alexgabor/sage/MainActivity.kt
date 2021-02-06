package com.alexgabor.sage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Providers
import androidx.compose.ui.platform.setContent
import com.alexgabor.sage.arch.ControllerStore
import com.alexgabor.sage.navigation.Navigation
import com.alexgabor.sage.screen.SageApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigation: Navigation
    private lateinit var controllerStore: ControllerStore

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SageApplication).appComponent.inject(this)
        controllerStore = (applicationContext as SageApplication).controllerComponent.controllerStore
        super.onCreate(savedInstanceState)
        setContent {
            Providers(
                HostActivity provides this,
                Controllers provides controllerStore,
            ) {
                SageApp()
            }
        }
    }

    override fun onBackPressed() {
        if (!navigation.goBack()) {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) {
            controllerStore.clear()
        }
    }
}