package com.example.secretnotescalculator.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val text: String,
)

fun NoteEntity.toDomain() = NoteDomain(title = title, text = text)