package com.example.buoi13.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buoi13.R
import com.example.buoi13.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private val viewModel by lazy { ViewModelProvider(this)[ListViewModel::class.java] }
    private val noteAdapter = NoteAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refresh()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rclNoteList.layoutManager = LinearLayoutManager(context)
        binding.rclNoteList.adapter = noteAdapter
        viewModel.noteList.observe(viewLifecycleOwner) {list ->
            noteAdapter.setData(list)
        }
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }
}