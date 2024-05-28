package com.example.btvnb10

import android.app.DatePickerDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvnb10.databinding.ActivityDetailBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val database = FirebaseFirestore.getInstance()
    private val itemAdapter = ItemAdapter { onItemClick(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var totalExpense = 0
        var totalIncome = 0

        binding.dtDate.setOnClickListener {
            DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    binding.dtDate.setText("$dayOfMonth/${month + 1}/$year")
                },
                2024,
                5,
                18
            ).show()
        }

        binding.recyclerView.adapter = itemAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        database.collection("Items")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Log.w(TAG, "Listen failed.", error)
                    return@addSnapshotListener
                }

                val itemList = mutableListOf<Item>()
                totalExpense = 0 // Reset totalExpense trước khi tính lại

                if (value != null) {
                    for (document in value) {
                        val item = document.toObject<Item>()
                        itemList.add(item)
                        totalExpense += item.amount ?: 0
                    }
                }

                // Cập nhật TextView sau khi tính toán xong
                binding.tvChiTieu.text = totalExpense.toString()
                binding.tvRemain.text = (totalIncome - totalExpense).toString()
            }

        database.collection("Items2")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Log.w(TAG, "Listen failed.", error)
                    return@addSnapshotListener
                }

                val itemList = mutableListOf<Item>()
                totalIncome = 0 // Reset totalIncome trước khi tính lại

                if (value != null) {
                    for (document in value) {
                        val item = document.toObject<Item>()
                        itemList.add(item)
                        totalIncome += item.amount ?: 0
                    }
                }

                // Cập nhật TextView sau khi tính toán xong
                binding.tvThuNhap.text = totalIncome.toString()
                binding.tvRemain.text = (totalIncome - totalExpense).toString()
            }

        binding.btnChiTieu.setOnClickListener {
            val dateText = binding.dtDate.text.toString()
            database.collection("Items")
                .whereEqualTo("date", dateText)
                .get()
                .addOnSuccessListener { value ->
                    val itemList = mutableListOf<Item>()
                    if (value != null) {
                        for (document in value) {
                            val item = document.toObject<Item>()
                            itemList.add(item)
                        }
                    }
                    itemAdapter.setList(itemList)
                }
                .addOnFailureListener { error ->
                    Log.w(TAG, "Error getting documents: ", error)
                }
        }

        binding.btnThuNhap.setOnClickListener {
            val dateText = binding.dtDate.text.toString()
            database.collection("Items2")
                .whereEqualTo("date", dateText)
                .get()
                .addOnSuccessListener { value ->
                    val itemList = mutableListOf<Item>()
                    if (value != null) {
                        for (document in value) {
                            val item = document.toObject<Item>()
                            itemList.add(item)
                        }
                    }
                    itemAdapter.setList(itemList)
                }
                .addOnFailureListener { error ->
                    Log.w(TAG, "Error getting documents: ", error)
                }
        }
    }
    private fun onItemClick(view: Int) {
        val intent = Intent(this, DetailActivity2::class.java).apply {
            putExtra("ICON", view)
        }
        startActivity(intent)
    }
}
