package com.example.btvnb10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    private var listItem = mutableListOf<Item>()
    class  ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //val title = view.findViewById<TextView>(R.id.item_title)
        val note = view.findViewById<TextView>(R.id.note_ic)
        val date = view.findViewById<TextView>(R.id.date_ic)
        val amount = view.findViewById<TextView>(R.id.amount_ic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detail_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.title.text = listItem[position].name
        holder.note.text = listItem[position].note
        holder.date.text = listItem[position].date
        holder.amount.text = listItem[position].amount.toString()
    }
    fun setList(newList: MutableList<Item>){
        listItem = newList
        notifyDataSetChanged()
    }
}