package com.example.btvnb10

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.btvnb10.databinding.FragmentIncomeBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class IncomeFragment : Fragment() {
    val binding by lazy { FragmentIncomeBinding.inflate(layoutInflater) }
    private var ic_cat = 0
    private val auth = Firebase.auth
    private val database = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.icDate.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { DatePicker, i1, i2, i3 ->
                    binding.icDate.setText("$i3/${i2 + 1}/$i1")
                },
                2024,
                5,
                21
            ).show()
        }

        binding.btnSave.setOnClickListener {
            auth.currentUser?.let { _ ->
                val newItem = Item(
                    icon = this.ic_cat,
                    name = binding.icCategory.text.toString(),
                    date = binding.icDate.text.toString(),
                    note = binding.icNote.text.toString(),
                    amount = binding.icAmount.text.toString().toInt()
                )
                database.collection("Items2")
                    .add(newItem)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Thêm thành công", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(requireContext(), "Không thành công", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        binding.btnBonus.setOnClickListener {
            binding.icCategory.text = binding.tvBonus.text
            ic_cat = R.drawable.ic_bonus
        }
        binding.btnExtra.setOnClickListener {
            binding.icCategory.text = binding.tvExtra.text
            ic_cat = R.drawable.ic_extra
        }
        binding.btnInvestment.setOnClickListener {
            binding.icCategory.text = binding.tvInvestment.text
            ic_cat = R.drawable.ic_investment
        }
        binding.btnPocketMoney.setOnClickListener {
            binding.icCategory.text = binding.tvPocketMoney.text
            ic_cat = R.drawable.ic_pocket_money
        }
        binding.btnSideJob.setOnClickListener {
            binding.icCategory.text = binding.tvSideJob.text
            ic_cat = R.drawable.ic_side_job
        }
        binding.btnSalary.setOnClickListener {
            binding.icCategory.text = binding.tvSalary.text
            ic_cat = R.drawable.ic_salary
        }
    }
}