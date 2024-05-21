package com.example.test

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM NOTE_TABLE")
    fun getAllNote(): List<Note>
    @Insert
    fun insertNote(note: Note)
    @Query("SELECT * FROM note_table WHERE isFavourite = TRUE")
    fun getFavNote():List<Note>
}