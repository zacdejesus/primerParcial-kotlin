package com.example.primerparcial_kotlin.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.R
import com.example.primerparcial_kotlin.models.Student

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val stundentNameTitle = view.findViewById<TextView>(R.id.textViewNameStudent)
    val stundentImage = view.findViewById<ImageView>(R.id.imageViewList)

    fun render(student: Student) {
        stundentNameTitle.text = student.name
    }

}