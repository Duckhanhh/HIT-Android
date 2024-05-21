package com.example.btvnb10

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.btvnb10.databinding.FragmentIncomeBinding

class IncomeFragment : Fragment() {
    val binding by lazy { FragmentIncomeBinding.inflate(layoutInflater) }
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
    }
}