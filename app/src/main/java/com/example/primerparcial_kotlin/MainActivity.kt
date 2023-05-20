package com.example.primerparcial_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.adapter.StudentAdapter
import com.example.primerparcial_kotlin.models.Student
import com.example.primerparcial_kotlin.viewModels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = MainActivityViewModel()
    private var students = mutableListOf<Student>()

    private lateinit var adapter: StudentAdapter
    private lateinit var recyclerView: RecyclerView

    // LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        viewModel.saveStudentListToSharedPreferences(this,studentList)
    }

    private fun showAddStudentsActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        // This code block is called every time the Activity is shown

        students = viewModel.retrieveStudentListFromSharedPreferences(context = this)
        adapter = StudentAdapter(students)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    // Methods
    private fun initRecyclerView() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerStudent)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter(viewModel.retrieveStudentListFromSharedPreferences(this))
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}