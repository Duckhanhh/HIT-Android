package com.example.buoi13.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buoi13.MyApplication
import com.example.buoi13.data.Note
import com.example.buoi13.data.NoteRepository
import com.example.buoi13.data.source.local.NoteRoomDatabase
import com.example.buoi13.data.source.remote.NetworkNoteDataSource
import kotlinx.coroutines.launch


class ListViewModel : ViewModel() {
    private val repository = NoteRepository(
        NoteRoomDatabase.getDatabase(MyApplication.getContext()).noteDao(),
        NetworkNoteDataSource()
    )

    val noteList: LiveData<List<Note>> get() = repository.getAll()
    fun refresh() {
        viewModelScope.launch {
            repository.refresh()
        }
    }
}