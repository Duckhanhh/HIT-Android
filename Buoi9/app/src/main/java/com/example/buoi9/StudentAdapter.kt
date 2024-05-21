package com.example.buoi9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class StudentAdapter(
    val list: List<Student> = mutableListOf()
) : Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View) : ViewHolder(view) {
        val tvId = itemView.findViewById<TextView>(R.id.id)
        val tvName = itemView.findViewById<TextView>(R.id.nameId)
        val tvAge = itemView.findViewById<TextView>(R.id.AgeId)
        val tvAddress = itemView.findViewById<TextView>(R.id.AddressId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.tvId.text = list[position].id
        holder.tvName.text = list[position].nameStudent
        holder.tvAge.text = list[position].ageStudent.toString()
        holder.tvAddress.text = list[position].addressStudent
    }

    override fun getItemCount() = list.size
}
