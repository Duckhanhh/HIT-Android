package com.example.buoi13.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.buoi13.data.Note
import java.util.Date

@Entity(tableName = "Note")
data class LocalNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val title: String?,
    val createdOn: Date?,
    val content: String?
)

fun LocalNote.toNote(): Note {
    return Note(
        id = id,
        title = title,
        createdOn = createdOn,
        content = content
    )
}

fun List<LocalNote>.toListNote(): List<Note> {
    return map {
        it.toNote()
    }
}

fun Note.toLocalNote(): LocalNote {
    return LocalNote(
        id = id,
        title = title,
        createdOn = createdOn,
        content = content
    )
}