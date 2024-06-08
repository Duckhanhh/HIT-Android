package com.example.buoi13.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDAO {
    @Query("SELECT * FROM NOTE")
    fun getAll(): LiveData<MutableList<LocalNote>>

    @Upsert
    suspend fun upsert(note: LocalNote)

    @Upsert
    suspend fun upsertAll(notes: List<LocalNote>)

    @Query("DELETE FROM NOTE")
    suspend fun deleteAll()
}