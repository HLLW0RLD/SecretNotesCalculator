package com.example.secretnotescalculator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.secretnotescalculator.presentation.calculator.CalculatorScreen
import com.example.secretnotescalculator.presentation.theme.SecretNotesCalculatorTheme
import org.koin.core.component.KoinComponent

class MainActivity : ComponentActivity(), KoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SecretNotesCalculatorTheme {
                Navigator(screen = CalculatorScreen()) { navigator ->
                    SlideTransition(navigator) {
                        it.Content()
                    }
                }
            }
        }
    }
}
