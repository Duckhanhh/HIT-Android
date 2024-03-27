package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val content = intent.getStringExtra("key")
        val user: User? = intent.getParcelableExtra("user")
        val textview: TextView = findViewById(R.id.textview)
        textview.text = "Ban vua nhap: " + content

        textview.text = user.toString()
    }
}
