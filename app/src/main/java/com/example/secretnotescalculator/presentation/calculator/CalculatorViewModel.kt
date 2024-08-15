package com.example.secretnotescalculator.presentation.calculator

import com.example.secretnotescalculator.data.domain.base.BaseViewModel

class CalculatorViewModel: BaseViewModel
<CalculatorState, CalculatorEvent, CalculatorAction>(CalculatorState(0)) {

    override fun obtainEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.OnCreate -> OnCreate()
            is CalculatorEvent.SumChanged -> chageSum(event.sum)
            is CalculatorEvent.Plus -> increase(event.sum)
            is CalculatorEvent.Minus -> decrease(event.sum)
            is CalculatorEvent.OpenPhysicCalculator -> action = CalculatorAction.OpenSecretNotes
        }
    }

    fun OnCreate() {
        viewState = viewState.copy(sum = 0)
    }

    fun chageSum(s: Long) {
        viewState = viewState.copy(sum = s)
    }

    fun increase(s : Long) {
        viewState = viewState.copy(sum = s + 1)
    }

    fun decrease(s : Long) {
        viewState = viewState.copy(sum = s - 1)
    }
}