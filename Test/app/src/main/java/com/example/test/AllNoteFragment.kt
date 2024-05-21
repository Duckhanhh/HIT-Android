package com.example.test

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buoi7.NoteRoomDatabase
import com.example.test.databinding.FragmentAllNoteBinding

class AllNoteFragment : Fragment() {
    val applicationContext: Context
        get() {
            TODO()
        }
    val binding by lazy { FragmentAllNoteBinding.inflate(layoutInflater) }
    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
    private val itemAdapter = ItemAdapter(noteRoomDatabase.noteDao().getAllNote())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}