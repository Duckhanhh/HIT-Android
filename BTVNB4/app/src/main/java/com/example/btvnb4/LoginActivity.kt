package com.example.btvnb4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.btvnb4.databinding.LoginScreenBinding

class LoginActivity : AppCompatActivity() {
    private val binding by lazy { LoginScreenBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val login_bt: Button = binding.btDangNhap
        val register_bt: Button = binding.btDangKi
        val editText_username: EditText = binding.Username
        val editText_password: EditText = binding.Password

        login_bt.setOnClickListener {
            val username_content = editText_username.text.toString()
            val password_content = editText_password.text.toString()

            if (checkList(username_content, password_content)) {
                val intent = Intent(this, HomeScreenActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Không có thông tin của user", Toast.LENGTH_SHORT).show()
            }
        }

        register_bt.setOnClickListener {
            val intent = Intent(this, RegisterScreen::class.java)
            startActivity(intent)
        }
    }

    fun checkList(checkun: String, checkpw: String): Boolean {
        val user_checking = User("", checkun, checkpw)
        val users = HomeScreenActivity().list
        for (user in users) {
            if (user_checking.username == user.username && user_checking.password == user.password) {
                return true
            }
        }
        return false
    }
}
