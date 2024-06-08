package com.example.buoi13.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.buoi13.data.source.local.NoteDAO
import com.example.buoi13.data.source.local.toListNote
import com.example.buoi13.data.source.local.toLocalNote
import com.example.buoi13.data.source.remote.NetworkNoteDataSource
import com.example.buoi13.data.source.remote.toNetworkNote
import com.example.buoi13.data.source.remote.toNote

class NoteRepository(
    private val noteDAO: NoteDAO,
    private val networkNoteDataSource: NetworkNoteDataSource
) {
    fun getAll(): LiveData<List<Note>> {
        return noteDAO.getAll().map { localNotes ->
            localNotes.toListNote()
        }
    }

    suspend fun create(note: Note) {
        noteDAO.upsert(note.toLocalNote())
        networkNoteDataSource.create(note.toNetworkNote())
    }

    suspend fun refresh() {
        val networkNoteData = networkNoteDataSource.getData().map { networkNote ->
            networkNote.toNote()
        }
        noteDAO.deleteAll()
        noteDAO.upsertAll(networkNoteData.map { note ->
            note.toLocalNote()
        })
    }
}