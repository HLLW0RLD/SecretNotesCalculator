package com.example.secretnotescalculator.presentation.notes.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.secretnotescalculator.presentation.theme.SecretNotesCalculatorTheme

@Composable
fun NoteView(
    state: NoteState,
    eventConsumer: (NoteEvent) -> Unit
) {
    Column(modifier =
    Modifier
        .fillMaxSize()
        .background(Color.DarkGray),

    ) {
        Button(onClick = { eventConsumer(NoteEvent.Close) }) {
            Text(text = "back")
        }
        LazyColumn {
            itemsIndexed(items = state.noteList) { index, item ->
                Text(text = state.noteList[index], Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally))
            }
        }
    }
}

@Composable
@Preview
fun test() {
    SecretNotesCalculatorTheme {
        NoteView(state = NoteState(listOf("1", "2", "3"))) {}
    }
}