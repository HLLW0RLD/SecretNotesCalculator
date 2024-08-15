package com.example.secretnotescalculator.data.domain.repository

import com.example.secretnotescalculator.data.domain.base.BaseRepository

interface NotesRepository: BaseRepository {

    fun getAllNotes()
    fun createNote()
    fun updateNote()
    fun deleteNote()
    fun deleteAllNotes()
}