package com.example.btvnb4

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvnb4.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeScreenBinding.inflate(layoutInflater) }
    val list: MutableList<User> = mutableListOf(
        User("Nguyen Duc Khanh", "Duckk", "123321"),
        User("Nguyen Thi B", "BBBBB", "123333")
    )
    private val userAdapter = UserAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val fullname = intent.getStringExtra("fullname")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        if (fullname != null && username != null && password != null) {
            val user = User(fullname, username, password)
            list.add(user)
        }
        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.logout.setOnClickListener{
            val intent = Intent(this, LoginScreenActivity:: class.java)
            startActivity(intent)
        }
    }
}