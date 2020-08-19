package com.alexgabor.sage.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_AssistedModule::class])
internal abstract class AssistedModule