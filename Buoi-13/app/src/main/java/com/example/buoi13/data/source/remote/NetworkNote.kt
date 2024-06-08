package com.example.buoi13.data.source.remote

import androidx.room.PrimaryKey
import com.example.buoi13.data.Note
import java.util.Date

data class NetworkNote(
    val id: Int?,
    val title: String?,
    val createdOn: Date?,
    val content: String?
)
fun NetworkNote.toNote(): Note {
    return Note(
        id = id,
        title = title,
        createdOn = createdOn,
        content = content
    )
}

fun List<NetworkNote>.toListNote(): List<Note> {
    return map {
        it.toNote()
    }
}

fun Note.toNetworkNote(): NetworkNote {
    return NetworkNote(
        id = id,
        title = title,
        createdOn = createdOn,
        content = content
    )
}