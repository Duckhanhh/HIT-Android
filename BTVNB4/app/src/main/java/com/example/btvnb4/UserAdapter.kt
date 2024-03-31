package com.example.btvnb4

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    val userList: MutableList<User> = mutableListOf(),
) : RecyclerView.Adapter<UserAdapter.userViewHolder>() {
    class userViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsername = itemView.findViewById<TextView>(R.id.usname)
        val tvFullname = itemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return userViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        holder.tvFullname.text = userList[position].fullname
        holder.tvUsername.text = userList[position].username
    }
}
