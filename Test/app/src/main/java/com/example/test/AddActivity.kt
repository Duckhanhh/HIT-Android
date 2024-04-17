package com.example.test

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityAddBinding
import java.util.Date

class AddActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btSavenote.setOnClickListener {
            val title: String = binding.edTitle.text.toString()
            val content: String = binding.edContent.text.toString()
            val time: Date = Date()
            val isFav: Boolean = false
            val note = Note(title, content, time, isFav)
            DataItem.list.add(note)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}