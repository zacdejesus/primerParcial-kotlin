package com.example.primerparcial_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.primerparcial_kotlin.adapter.StudentAdapter
import com.example.primerparcial_kotlin.databinding.ActivityMainBinding
import com.example.primerparcial_kotlin.models.Student
import com.example.primerparcial_kotlin.viewModels.StudentsManager

class MainActivity : AppCompatActivity() {

    private val studentsManager = StudentsManager()
    private var students = mutableListOf<Student>()

    private lateinit var adapter: StudentAdapter


    private  lateinit var binding: ActivityMainBinding

    // LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.addStudentButton)

        button.setOnClickListener {
            showAddStudentsActivity()
        }

        addStudents10AskedDueRequirements()
        initRecyclerView()
        showAddStudentsActivity()
    }

    private fun addStudents10AskedDueRequirements() {
        val studentList = mutableListOf(Student("Maria", age = "10", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("pedro", age = "43", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Zad", age = "43", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Calor", age = "53", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Candela", age = "43", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Yeison", age = "3", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Ronaldo", age = "2", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Pele", age = "22", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Josefa", age = "10", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Alexandra", age = "10", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"))

        studentsManager.saveStudentListToSharedPreferences(this,studentList)
    }

    private fun showAddStudentsActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        // This code block is called every time the Activity is shown

        students = studentsManager.retrieveStudentListFromSharedPreferences(context = this)
        adapter = StudentAdapter(students)
        binding.recyclerStudent.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    // Methods
    private fun initRecyclerView() {


        binding.recyclerStudent.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter(studentsManager.retrieveStudentListFromSharedPreferences(this))
        binding.recyclerStudent.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}