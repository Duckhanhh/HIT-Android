package com.example.buoi4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    val userList : MutableList<User> = mutableListOf()
) : RecyclerView.Adapter<UserAdapter.userVIewHolder>() {
    class userVIewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsername = itemView.findViewById<TextView>(R.id.name)
        val tvAddress = itemView.findViewById<TextView>(R.id.address)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userVIewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return userVIewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: userVIewHolder, position: Int) {
        holder.tvUsername.text = userList[position].username
        holder.tvAddress.text = userList[position].address

        holder.tvUsername.setOnClickListener{
            Toast.makeText(holder.tvUsername.context, "UWU", Toast.LENGTH_SHORT).show()
        }
        holder.tvAddress.setOnClickListener {
            userList.removeAt(position)
            notifyDataSetChanged() // tbao data bi thay doi
        }
    }
}