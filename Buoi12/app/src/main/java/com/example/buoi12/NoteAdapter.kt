package com.example.buoi12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.itemViewHolder>() {
    private var noteList = mutableListOf<Note>()

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val date = itemView.findViewById<TextView>(R.id.tv_date)
        val content = itemView.findViewById<TextView>(R.id.tv_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return itemViewHolder(view)
    }

    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.title.text = noteList[position].title
        holder.date.text = noteList[position].date.toString()
        holder.content.text = noteList[position].content
    }
}