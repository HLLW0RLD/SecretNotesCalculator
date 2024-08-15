package com.example.secretnotescalculator.data.di

import com.example.secretnotescalculator.presentation.calculator.CalculatorViewModel
import com.example.secretnotescalculator.presentation.notes.list.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CalculatorViewModel() }
    viewModel { NoteViewModel() }
}