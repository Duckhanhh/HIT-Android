package com.example.btvnb5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.btvnb5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val homeFragment = HomeFragment()
    private val userFragment = UserFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, homeFragment)
                setReorderingAllowed(true)
            }
        }
        binding.user.setOnClickListener{
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, userFragment)
                setReorderingAllowed(true)
            }
        }
    }
}