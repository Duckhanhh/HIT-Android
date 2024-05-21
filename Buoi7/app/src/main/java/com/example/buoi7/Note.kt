package com.example.buoi7

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("content")
    val content: String,
)