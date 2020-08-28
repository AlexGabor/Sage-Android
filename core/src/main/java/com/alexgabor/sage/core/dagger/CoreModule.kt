package com.alexgabor.sage.core.dagger

import dagger.Module

@Module(
    includes = [DbModule::class],
)
object CoreModule