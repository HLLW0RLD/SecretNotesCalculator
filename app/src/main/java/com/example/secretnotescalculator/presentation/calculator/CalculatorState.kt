package com.example.secretnotescalculator.presentation.calculator

import com.example.secretnotescalculator.data.domain.base.BaseAction
import com.example.secretnotescalculator.data.domain.base.BaseEvent
import com.example.secretnotescalculator.data.domain.base.BaseState

data class CalculatorState(
    val sum: Long?
): BaseState

sealed class CalculatorEvent : BaseEvent {
    object OnCreate : CalculatorEvent()
    data class SumChanged(val sum: Long) : CalculatorEvent()
    data class Plus(val sum: Long) : CalculatorEvent()
    data class Minus(val sum: Long) : CalculatorEvent()
    object OpenPhysicCalculator : CalculatorEvent()
}
sealed class CalculatorAction : BaseAction {
    object OpenSecretNotes : CalculatorAction()
}