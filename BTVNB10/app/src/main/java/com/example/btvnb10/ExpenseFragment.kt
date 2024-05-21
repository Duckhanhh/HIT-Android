package com.example.btvnb10

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.btvnb10.databinding.FragmentExpenseBinding
import java.util.Calendar

class ExpenseFragment : Fragment() {
    val binding by lazy { FragmentExpenseBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { activity as MainActivity }
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
    }
}