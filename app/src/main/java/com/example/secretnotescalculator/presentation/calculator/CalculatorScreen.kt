package com.example.secretnotescalculator.presentation.calculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.secretnotescalculator.data.domain.base.BaseScreen
import com.example.secretnotescalculator.presentation.notes.list.NoteScreen
import com.example.secretnotescalculator.presentation.theme.SecretNotesCalculatorTheme

class CalculatorScreen: BaseScreen() {
    @Composable
    override fun Content() {
        CalculatorScreen(viewModel = getScreenModel())
    }
}

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel
) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (action) {
            null -> {}
            CalculatorAction.OpenSecretNotes -> {
                navigator.push(NoteScreen())
            }
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.obtainEvent(CalculatorEvent.OnCreate)
    }

    SecretNotesCalculatorTheme {
        CalculatorView(state = state, eventConsumer = viewModel::obtainEvent)
    }
}