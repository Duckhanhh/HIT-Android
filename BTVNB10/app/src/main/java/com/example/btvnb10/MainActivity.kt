package com.example.btvnb10

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.btvnb10.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val expenseFragment = ExpenseFragment();
    private val incomeFragment = IncomeFragment();
    private val auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(binding.fragmentContainerViewTag.id, expenseFragment)
            setReorderingAllowed(true)
        }

        binding.rbChiTieu.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, expenseFragment)
                setReorderingAllowed(true)
            }
        }

        binding.rbThuNhap.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerViewTag.id, incomeFragment)
                setReorderingAllowed(true)
            }
        }

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }

        binding.btnStatistics.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }
}