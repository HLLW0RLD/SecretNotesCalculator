package com.example.secretnotescalculator.presentation.notes.list

import com.example.secretnotescalculator.data.domain.base.BaseViewModel

class NoteViewModel: BaseViewModel<NoteState, NoteEvent, NoteAction>(NoteState(listOf())) {
    override fun obtainEvent(event: NoteEvent) {
        when(event) {
            NoteEvent.Close -> action = NoteAction.Close
        }
    }
}