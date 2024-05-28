package com.example.btvnb10

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvnb10.databinding.ActivityDetail2Binding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class DetailActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityDetail2Binding.inflate(layoutInflater) }
    private val database = FirebaseFirestore.getInstance()
    private val detailAdapter = DetailAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val icon = intent.getIntExtra("ICON", 0)
        var total = 0

        binding.recyclerView.adapter = detailAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        database.collection("Items")
            .whereEqualTo("icon", icon)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    // Biểu tượng tồn tại trong Items
                    loadItemsFromCollection("Items", icon)
                } else {
                    // Biểu tượng không tồn tại trong Firestore
                    loadItemsFromCollection("Items2", icon)
                }
            }
        // Cập nhật TextView sau khi tính toán xong
        binding.total.text = total.toString()
    }

    private fun loadItemsFromCollection(collectionName: String, icon: Int): Int {
        var total = 0
        database.collection(collectionName)
            .whereEqualTo("icon", icon)
            .get()
            .addOnSuccessListener { value ->
                val itemList = mutableListOf<Item>()
                if (value != null) {
                    for (document in value) {
                        val item = document.toObject<Item>()
                        itemList.add(item)
                        total += item.amount!!
                    }
                    detailAdapter.setList(itemList)

                } else {
                    Log.e("DetailActivity2", "No documents found in $collectionName")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("DetailActivity2", "Error getting documents: ", exception)
            }
        return total
    }
}
