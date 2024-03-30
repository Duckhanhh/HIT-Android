package com.example.btvnb4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.btvnb4.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeScreenBinding.inflate(layoutInflater) }
    val list = mutableListOf<User>(
        User("Nguyen Duc Khanh", "Duckk", "123321"),
        User("Nguyen Thi B", "BBBBB", "123333")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)

    }
}