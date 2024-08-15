package com.example.secretnotescalculator.data.models

data class NoteDomain(
    val title: String?,
    val text: String?,
)

fun NoteDomain.toEntity() = NoteEntity(title = title ?: "", text = text ?: "")