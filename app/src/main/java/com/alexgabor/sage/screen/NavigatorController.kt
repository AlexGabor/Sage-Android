package com.alexgabor.sage.screen

import com.alexgabor.sage.arch.Controller
import com.alexgabor.sage.navigation.Navigation
import javax.inject.Inject

class NavigatorController @Inject constructor(navigation: Navigation) : Controller() {
    val navigationEvent = navigation.navigationEvent
}
