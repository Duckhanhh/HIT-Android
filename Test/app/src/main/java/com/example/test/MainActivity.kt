package com.example.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val allNoteFragment = AllNoteFragment()
    private val favouriteFragment = FavouriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, allNoteFragment)
            setReorderingAllowed(true)
        }

        binding.tvFavorite.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, favouriteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.tvAllnote.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainer.id, allNoteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btAddnote.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}