package com.example.btvnb10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var itemList = mutableListOf<Item>()
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon = view.findViewById<ImageView>(R.id.icon)
        val name = view.findViewById<TextView>(R.id.name)
        val amount = view.findViewById<TextView>(R.id.amount_of_money)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.icon.setImageResource(itemList[position].icon!!)
        holder.amount.text = itemList[position].amount.toString()
        holder.name.text = itemList[position].name
        holder.icon.setOnClickListener {
            onItemClick(itemList[position].icon!!)
            println(itemList[position].icon)
            println("-.-")
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(newList: MutableList<Item>){
        itemList = newList
        notifyDataSetChanged()
    }
}
