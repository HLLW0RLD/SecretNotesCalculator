package com.example.secretnotescalculator.presentation.notes.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.secretnotescalculator.data.domain.base.BaseScreen
import com.example.secretnotescalculator.presentation.calculator.CalculatorView
import com.example.secretnotescalculator.presentation.theme.SecretNotesCalculatorTheme

class NoteScreen: BaseScreen() {
    @Composable
    override fun Content() {
        NoteScreen(viewModel = getScreenModel())
    }
}

@Composable
fun NoteScreen(
    viewModel: NoteViewModel
) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (action) {
            null -> {}
            NoteAction.Close -> {
                navigator.pop()
            }
        }
    }

    SecretNotesCalculatorTheme {
        NoteView(state = state, eventConsumer = viewModel::obtainEvent)
    }
}