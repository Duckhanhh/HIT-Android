package com.example.buoi5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.example.buoi5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    var fullName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        supportFragmentManager.commit {
            replace(binding.fragmentContainerViewTag.id, firstFragment)
            setReorderingAllowed(true)
        }
        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, firstFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, secondFragment)
                setReorderingAllowed(true)
            }
        }
    }
}