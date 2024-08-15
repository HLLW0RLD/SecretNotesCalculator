package com.example.secretnotescalculator.data.domain.base

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
import cafe.adriel.voyager.core.lifecycle.DefaultScreenLifecycleOwner
import cafe.adriel.voyager.core.lifecycle.ScreenLifecycleOwner
import cafe.adriel.voyager.core.lifecycle.ScreenLifecycleProvider
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey

abstract class BaseScreen : Screen, ScreenLifecycleProvider {
    override val key: ScreenKey = uniqueScreenKey
    @OptIn(InternalVoyagerApi::class)
    override fun getLifecycleOwner(): ScreenLifecycleOwner = DefaultScreenLifecycleOwner
}
