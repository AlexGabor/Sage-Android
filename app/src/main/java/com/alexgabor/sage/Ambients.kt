package com.alexgabor.sage

import androidx.compose.runtime.ambientOf
import com.alexgabor.sage.arch.ControllerStore

val HostActivity = ambientOf<MainActivity> { error("No activity provided") }
val Controllers = ambientOf<ControllerStore> { error("ControllerStore not provided") }
