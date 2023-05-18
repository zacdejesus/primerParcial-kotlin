package com.example.primerparcial_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.R
import com.example.primerparcial_kotlin.models.Student

class StudentAdapter(private val students: List<Student>) : RecyclerView.Adapter<StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StudentViewHolder(layoutInflater.inflate(R.layout.item_student, parent, false))
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = students[position]
        holder.render(item)
    }
}