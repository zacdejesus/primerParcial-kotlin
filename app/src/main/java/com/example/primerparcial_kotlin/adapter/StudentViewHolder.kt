package com.example.primerparcial_kotlin.adapter

import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.DetailActivity
import com.example.primerparcial_kotlin.R
import com.example.primerparcial_kotlin.SecondActivity
import com.example.primerparcial_kotlin.databinding.ItemStudentBinding
import com.example.primerparcial_kotlin.models.Student

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val stundentNameTitle = view.findViewById<TextView>(R.id.textViewNameStudent)
    val stundentImage = view.findViewById<ImageView>(R.id.imageViewList)

    val binding = ItemStudentBinding.bind(view)

    fun render(student: Student) {
        stundentNameTitle.text = student.name
        stundentNameTitle.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("studentName", student.name)
            val intent = Intent(binding.imageViewList.context, DetailActivity::class.java)
            intent.putExtras(bundle)
            binding.imageViewList.context.startActivity(intent)
        }
    }

}