package com.example.btvnb10

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.btvnb10.databinding.FragmentExpenseBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class ExpenseFragment : Fragment() {
    val binding by lazy { FragmentExpenseBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { activity as MainActivity }
    private val auth = Firebase.auth
    private val database = Firebase.firestore
    private var ic_cat: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etDate.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { DatePicker, i1, i2, i3 ->
                    binding.etDate.setText("$i3/${i2 + 1}/$i1")
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
                    name = binding.category.text.toString(),
                    date = binding.etDate.text.toString(),
                    note = binding.etNote.text.toString(),
                    amount = binding.etAmount.text.toString().toInt()
                )
                database.collection("Items")
                    .add(newItem)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Thêm thành công", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(requireContext(), "Không thành công", Toast.LENGTH_SHORT)
                            .show()
                    }
            }
        }

        binding.btnFood.setOnClickListener {
            binding.category.text = binding.categoryFood.text
            ic_cat = R.drawable.ic_food
        }

        binding.btnClothes.setOnClickListener {
            binding.category.text = binding.categoryClothes.text
            ic_cat = R.drawable.ic_clothes
        }

        binding.btnContact.setOnClickListener {
            binding.category.text = binding.categoryContact.text
            ic_cat = R.drawable.ic_contact
        }

        binding.btnEducation.setOnClickListener {
            binding.category.text = binding.categoryEducation.text
            ic_cat = R.drawable.ic_education
        }

        binding.btnElectricBill.setOnClickListener {
            binding.category.text = binding.categoryElectricBill.text
            ic_cat = R.drawable.ic_electric_bill
        }

        binding.btnExchange.setOnClickListener {
            binding.category.text = binding.categoryExchange.text
            ic_cat = R.drawable.ic_exchange
        }

        binding.btnHouseWare.setOnClickListener {
            binding.category.text = binding.categoryHouseWare.text
            ic_cat = R.drawable.ic_house_ware
        }

        binding.btnMedical.setOnClickListener {
            binding.category.text = binding.categoryMedical.text
            ic_cat = R.drawable.ic_medical
        }
        binding.btnTransport.setOnClickListener {
            binding.category.text = binding.categoryTransport.text
            ic_cat = R.drawable.ic_transport
        }
    }
}