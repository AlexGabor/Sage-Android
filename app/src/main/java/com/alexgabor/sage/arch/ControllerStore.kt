package com.alexgabor.sage.arch

import com.alexgabor.sage.di.ControllerScope
import javax.inject.Inject
import javax.inject.Provider

@ControllerScope
class ControllerStore @Inject constructor(private val controllerMap: @JvmSuppressWildcards Map<Class<out Controller>, Provider<Controller>>) {
    private val map = mutableMapOf<String, Controller>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Controller> getController(key: Class<T>): T {
        return map.getOrPut(key.name) { controllerMap[key]?.get() ?: error("Controller for $key not provided") } as T
    }

    fun clear() {
        map.forEach { (_, controller) ->
            controller.clear()
        }
    }

    fun <T : Controller> clear(key: Class<T>) {
        map.remove(key.name)?.clear()
    }
}