package com.alexgabor.sage.di

import com.alexgabor.sage.arch.Controller
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ControllerKey(val classKey: KClass<out Controller>)