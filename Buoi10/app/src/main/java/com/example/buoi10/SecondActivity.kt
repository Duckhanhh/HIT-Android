package com.example.buoi10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi10.databinding.ActivitySecondBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    private val auth = Firebase.auth

    private val database = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth.currentUser?.let { user ->
            val x = user.uid
            database.collection("users")
                .document(user.uid)
                .get()
                .addOnSuccessListener {document ->
                    val user = document.toObject<User>()

                    binding.edtUsername.setText(user?.username.toString())
                    binding.edtAge.setText(user?.age.toString())
                    binding.edtAddress.setText(user?.address.toString())
                }
                .addOnFailureListener {

                }
        }

        binding.btn2.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }

        binding.btn3.setOnClickListener {
            auth.currentUser?.let {
                user -> val newUser = User(
                    username = binding.edtUsername.text.toString(),
                    address = binding.edtAddress.text.toString(),
                    age = binding.edtAge.text.toString().toInt()
                )
                database.collection("users")
                    .document(user.uid)
                    .set(newUser)
                    .addOnSuccessListener {
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        binding.btn4.setOnClickListener {
            database.collection("users")
                .get()
                .addOnSuccessListener{documents ->
                    val userList = mutableListOf<User>()
                    for(document in documents){
                        val user = document.toObject<User>()
                        userList.add(user)
                    }
                    println(userList)
                }
        }
    }
}