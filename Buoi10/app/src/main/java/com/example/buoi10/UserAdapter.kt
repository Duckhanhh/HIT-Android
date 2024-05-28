package com.example.buoi10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    val onItemClick: (TextView) -> Unit
) : RecyclerView.Adapter<UserAdapter.userViewHolder>() {
    private var userList = mutableListOf<User>()

    class userViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val tvAge = itemView.findViewById<TextView>(R.id.tvAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return userViewHolder(view);
    }


    override fun getItemCount() = userList.size


    override fun onBindViewHolder(holder: UserAdapter.userViewHolder, position: Int) {
        holder.tvUsername.text = userList[position].username
        holder.tvAddress.text = userList[position].address
        holder.tvAge.text = userList[position].age.toString()
        holder.tvUsername.setOnClickListener { view ->
            onItemClick(view as TextView)
        }
    }

    fun setList(newList: MutableList<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}
