package com.example.primerparcial_kotlin.adapter

import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.primerparcial_kotlin.DetailActivity
import com.example.primerparcial_kotlin.R
import com.example.primerparcial_kotlin.SecondActivity
import com.example.primerparcial_kotlin.databinding.ItemStudentBinding
import com.example.primerparcial_kotlin.models.Student

class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val stundentNameTitle = view.findViewById<TextView>(R.id.textViewNameStudent)
    val textViewAgeStudent = view.findViewById<TextView>(R.id.textViewAgeStudent)
    val stundentImage = view.findViewById<ImageView>(R.id.imageViewList)

    val binding = ItemStudentBinding.bind(view)

    fun render(student: Student) {
        var photoURL = student.photo
        if (student.photo == "") {
            photoURL = "https://img.freepik.com/free-photo/dreamy-cheerful-happy-little-girl-with-blond-hair-clasp-hands-together-joyfully-cannot-wait-outstanding-event-close-eyes-smiling-dreamy-feeling-overjoy-happiness-stand-white-wall_176420-36214.jpg?size=626&ext=jpg&ga=GA1.2.199583331.1684638000&semt=sph"
        }
        Glide.with(binding.imageViewList.context).load(photoURL).into(stundentImage)
        stundentNameTitle.text = student.name
        textViewAgeStudent.text = student.age
        stundentNameTitle.setOnClickListener {
            handleNavigation(student)
        }
        stundentImage.setOnClickListener {
            handleNavigation(student)
        }
    }

    fun handleNavigation(student: Student) {
        val bundle = Bundle()
        bundle.putString("studentName", student.name)
        val intent = Intent(binding.imageViewList.context, DetailActivity::class.java)
        intent.putExtras(bundle)
        binding.imageViewList.context.startActivity(intent)
    }
}