package com.example.secretnotescalculator.data.domain.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : BaseState, E : BaseEvent, A : BaseAction>(initialState: S)
    : ViewModel(), ScreenModel {

    private val _viewState = MutableStateFlow(initialState)
    private val _action = MutableSharedFlow<A>(replay = 0)

    protected val eventsScope = CoroutineScope(Dispatchers.IO)

    protected var viewState: S
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }

    protected var action: A? = null
        set(value) {
            viewModelScope.launch {
                if (value != null) {
                    _action.emit(value)
                } else {
                    _action.resetReplayCache()
                }
            }
        }

    val viewStates: StateFlow<S>
        get() = _viewState.asStateFlow()

    val viewActions: SharedFlow<A>
        get() = _action.asSharedFlow()

    open fun obtainEvent(event: E) {}

}