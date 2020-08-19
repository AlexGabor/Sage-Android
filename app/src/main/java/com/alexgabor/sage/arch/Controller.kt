package com.alexgabor.sage.arch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.onDispose
import androidx.compose.runtime.state
import com.alexgabor.sage.SageApplication
import com.alexgabor.sage.di.ControllerComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class Controller {

    private val controllerScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    open fun onCleared() {

    }

    fun clear() {
        controllerScope.cancel()
        onCleared()
    }
}

@Composable
inline fun <T: Controller> controller(init: ControllerComponent.() -> T): State<T> {
    val vm = state { controllerComponent().init() }
    onDispose { vm.value.clear() }
    return vm
}

fun controllerComponent() = SageApplication.app.controllerComponent