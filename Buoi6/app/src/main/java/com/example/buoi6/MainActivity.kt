package com.example.buoi6

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi6.databinding.ActivityMainBinding
import com.example.buoi6.databinding.DialogViewBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val alertDialog = AlertDialog.Builder(this)

        alertDialog.setTitle("Thong bao")
            .setMessage("Day la message")
            .setPositiveButton("Positive") { _, _ ->
            }
            .setNegativeButton("Negative") { _, _ ->
            }
            .setNeutralButton("Neutral") { _, _ ->
            }
            .setView(R.layout.dialog_view)


        val dialogBinding = DialogViewBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
            .setContentView(dialogBinding.root)

        dialogBinding.btnSend.setOnClickListener {
            binding.textview.text = dialogBinding.editTextFullname.toString() + dialogBinding.editTextDiachi.toString()
        }

        binding.button.setOnClickListener {
            dialog.show()
        }
    }
}