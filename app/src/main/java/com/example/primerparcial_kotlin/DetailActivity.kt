package com.example.primerparcial_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.primerparcial_kotlin.models.Student
import com.example.primerparcial_kotlin.viewModels.StudentsManager

class DetailActivity : AppCompatActivity() {

    private val studentsManager = StudentsManager()
    private lateinit var student: Student


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receivedBundle = intent.extras
        if (receivedBundle != null) {
            val studenNameFromBundle = receivedBundle.getString("studentName")
            val students = studentsManager.retrieveStudentListFromSharedPreferences(this)

            student = students.first { student -> student.name == studenNameFromBundle }

            val detailImage = findViewById<ImageView>(R.id.imageViewDetail)
            Glide.with(this).load(student.photo).into(detailImage)

            val nameText = findViewById<TextView>(R.id.nameDetail)
            nameText.text = student.name

            val agetext = findViewById<TextView>(R.id.ageDetail)
            agetext.text = student.age
        }
    }
}