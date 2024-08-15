package com.example.secretnotescalculator.presentation.notes.list

import androidx.compose.runtime.Immutable
import com.example.secretnotescalculator.data.domain.base.BaseAction
import com.example.secretnotescalculator.data.domain.base.BaseEvent
import com.example.secretnotescalculator.data.domain.base.BaseState

data class NoteState(
    val noteList: List<String>
): BaseState

sealed class NoteEvent : BaseEvent {
    object Close : NoteEvent()
}
sealed class NoteAction : BaseAction {
    object Close : NoteAction()
}