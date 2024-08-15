package com.example.secretnotescalculator.presentation.calculator

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.secretnotescalculator.App
import com.example.secretnotescalculator.presentation.theme.SecretNotesCalculatorTheme

@Composable
fun CalculatorView(
    state: CalculatorState,
    eventConsumer: (CalculatorEvent) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "${state.sum}",
            onValueChange = { eventConsumer(CalculatorEvent.SumChanged(it.toLong())) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            eventConsumer(CalculatorEvent.Plus(state.sum ?: 0))
        }) {
            Text("+")
        }
        Button(onClick = {
            eventConsumer(CalculatorEvent.Minus(state.sum ?: 0))
        }) {
            Text("-")
        }
        Button(onClick = {
            eventConsumer(CalculatorEvent.OpenPhysicCalculator)
        }) {
            Text("notes")
        }
    }
}

@Preview
@Composable
fun test() {
    SecretNotesCalculatorTheme {
        CalculatorView(state = CalculatorState(0), eventConsumer = {})
    }
}