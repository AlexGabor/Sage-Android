package com.alexgabor.sage.arch

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onDispose
import com.alexgabor.sage.Controllers
import com.alexgabor.sage.HostActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class Controller {

    protected val controllerScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    open fun onCleared() {

    }

    fun clear() {
        controllerScope.cancel()
        onCleared()
    }
}

@Composable
inline fun <reified T: Controller> controller(): T {
    val controllers = Controllers.current
    val host = HostActivity.current
    onDispose {
        if (!host.isChangingConfigurations) {
            Log.d("sageee", "dispose")
            controllers.clear(T::class.java)
        }
    }
    return controllers.getController(T::class.java)
}