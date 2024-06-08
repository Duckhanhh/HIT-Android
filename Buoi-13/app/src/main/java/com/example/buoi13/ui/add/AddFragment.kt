package com.example.buoi13.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buoi13.data.Note
import com.example.buoi13.databinding.FragmentAddBinding
import java.util.Date

class AddFragment : Fragment() {

    private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[AddViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSave.setOnClickListener {
            val note = Note(
                id = null,
                title = binding.edtTitle.text.toString(),
                content = binding.edtContent.text.toString(),
                createdOn = Date()
            )
            viewModel.createNote(note)
        }
    }
}