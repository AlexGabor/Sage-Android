package com.alexgabor.sage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.alexgabor.sage.navigation.Navigation
import com.alexgabor.sage.screen.SageApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigation: Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as SageApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            SageApp()
        }
    }

    override fun onBackPressed() {
        if (!navigation.goBack()) {
            super.onBackPressed()
        }
    }
}