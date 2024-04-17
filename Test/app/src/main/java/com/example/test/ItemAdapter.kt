package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    val noteList: MutableList<Note> = mutableListOf(),
) : RecyclerView.Adapter<ItemAdapter.itemViewHolder>() {

    class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        val tvTime = itemView.findViewById<TextView>(R.id.tv_time)
        val tvContent = itemView.findViewById<TextView>(R.id.tv_content)
        var isFav = itemView.findViewById<ImageView>(R.id.isfav)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return itemViewHolder(view)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.tvTitle.text = noteList[position].title
        holder.tvTime.text = noteList[position].createdAt.toString()
        holder.tvContent.text = noteList[position].content
        holder.isFav.isPressed = noteList[position].isFavorite
    }
}