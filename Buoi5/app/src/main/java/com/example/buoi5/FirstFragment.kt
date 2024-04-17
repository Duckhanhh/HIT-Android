package com.example.buoi5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.buoi5.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    val binding by lazy { FragmentFirstBinding.inflate(layoutInflater) }
    private val mainActivity by lazy { activity as MainActivity }
    var fullname: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            mainActivity.fullName = binding.editTextId.text.toString()
        }
    }
}