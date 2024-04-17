package com.example.btvnb4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.btvnb4.databinding.ActivityRegisterScreenBinding

class RegisterScreen : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val editText_fullname: EditText = binding.FullnameRg
        val editText_username: EditText = binding.UsernameRg
        val editText_password: EditText = binding.PasswordRg
        val button_register: Button = binding.Register

        button_register.setOnClickListener {
            val fullname = editText_fullname.text.toString()
            val username = editText_username.text.toString()
            val password = editText_password.text.toString()

            val intent = Intent(this, HomeScreenActivity::class.java)
            intent.putExtra("fullname", fullname)
            intent.putExtra("username", username)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }
}