package com.example.buoi13.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.buoi13.R
import com.example.buoi13.data.Note

class NoteAdapter : Adapter<NoteAdapter.NoteViewHolder>() {

    private var noteList = mutableListOf<Note>()

    class NoteViewHolder(view: View) : ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val createdOn: TextView = view.findViewById(R.id.tvCreatedOn)
        val content: TextView = view.findViewById(R.id.tvContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        with(holder) {
            title.text = note.title
            content.text = note.content
            createdOn.text = note.createdOn.toString()
        }
    }

    fun setData(noteList: List<Note>) {
        this.noteList = noteList.toMutableList()
        notifyDataSetChanged()
    }
}