package com.example.buoi10

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buoi10.databinding.ActivityThirdBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }
    private val database = Firebase.firestore
    private val userAdapter = UserAdapter { view ->
        onItemClick(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = userAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        database.collection("users")
            .addSnapshotListener { value, error ->
                val userList = mutableListOf<User>()
                if (value != null) {
                    for (user in value) {
                        val user = user.toObject<User>()
                        userList.add(user)
                    }
                }
                userAdapter.setList(userList)
            }
    }

    private fun onItemClick(view: TextView) {
        Toast.makeText(this, view.text, Toast.LENGTH_SHORT).show()
    }
}