package com.alexgabor.sage.arch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.onDispose
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

@Composable
fun composeScope(
    context: CoroutineContext = Dispatchers.Main
): CoroutineScope {
    val coroutineScope = CoroutineScope(context)
    onDispose { coroutineScope.cancel() }
    return coroutineScope
}