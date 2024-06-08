package com.example.buoi13.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buoi13.MyApplication
import com.example.buoi13.data.Note
import com.example.buoi13.data.NoteRepository
import com.example.buoi13.data.source.local.NoteRoomDatabase
import com.example.buoi13.data.source.remote.NetworkNoteDataSource
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {
    private val repository = NoteRepository(
        NoteRoomDatabase.getDatabase(MyApplication.getContext()).noteDao(),
        NetworkNoteDataSource()
    )

    fun createNote(note: Note) {
        viewModelScope.launch {
            repository.create(note)
        }
    }
}