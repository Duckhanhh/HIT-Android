package com.example.buoi13.data.source.remote

import java.util.Date

class NetworkNoteDataSource {
    private val noteList = mutableListOf<NetworkNote>(
        NetworkNote(1, "1", Date(), "1"),
        NetworkNote(2, "2", Date(), "2"),
        NetworkNote(3, "3", Date(), "3")
    )

    suspend fun getData(): List<NetworkNote> {
        return noteList
    }

    suspend fun create(networkNote: NetworkNote){
        noteList.add(networkNote)
    }
}
