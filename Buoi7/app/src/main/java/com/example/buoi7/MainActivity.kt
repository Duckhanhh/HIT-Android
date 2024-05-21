package com.example.buoi7

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi7.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val noteRoomDatabase by lazy { NoteRoomDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonAddnote.setOnClickListener {
            val note = Note(
                title = binding.editTextTitle.text.toString(),
                content = binding.editTextContent.text.toString()
            )
            CoroutineScope(Dispatchers.IO).launch {
                noteRoomDatabase.noteDao().addNote(note)
            }

        }
        binding.buttonShow.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                println(noteRoomDatabase.noteDao().getAllNote())
            }
        }
    }
}