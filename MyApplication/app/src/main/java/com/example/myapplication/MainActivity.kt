package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.button1)
        var edittext: EditText = findViewById(R.id.edittext)
        button.setOnClickListener {
            println("ok")
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show()

            val content = edittext.text.toString()
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("key", content)

            val user = User("Duckkk", true)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}