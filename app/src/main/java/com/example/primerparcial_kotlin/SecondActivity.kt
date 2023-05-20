package com.example.primerparcial_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.primerparcial_kotlin.models.Student
import com.example.primerparcial_kotlin.viewModels.StudentsManager

class SecondActivity : AppCompatActivity() {

    private val studentsManager = StudentsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            onSubmitButtonClick()
        }
    }


    private fun onSubmitButtonClick() {
        val nameEditText = findViewById<EditText>(R.id.editTextTextPersonName)
        val name = nameEditText.text.toString()

        val ageEditText = findViewById<EditText>(R.id.editTextTextPersonAge)
        val age = ageEditText.text.toString()

        val photoEditText = findViewById<EditText>(R.id.editTextTextPersonPhotoURL)
        val photo = photoEditText.text.toString()

        if (name != "" && age != "") {
            val students = studentsManager.retrieveStudentListFromSharedPreferences(context = this)

            val studentToAdd = Student(name, age, photo)
            students.add(0, studentToAdd)

            studentsManager.saveStudentListToSharedPreferences(context = this, studentList = students)

            finish()

        } else {
            Toast.makeText(this, "Faltan campos", Toast.LENGTH_SHORT).show()
        }

    }

}