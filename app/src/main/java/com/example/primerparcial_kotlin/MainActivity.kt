package com.example.primerparcial_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
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

        setUpAddStudentsButton()
        setupStudents()
        setUpFilter()
        initRecyclerView()
        showAddStudentsActivity()
    }

    private fun setUpAddStudentsButton() {
        val button = findViewById<Button>(R.id.addStudentButton)

        button.setOnClickListener {
            showAddStudentsActivity()
        }
    }
    private fun setupStudents() {

        if (studentsManager.retrieveStudentListFromSharedPreferences(context = this).isEmpty()) {
            addStudents10AskedDueRequirements()
            students = studentsManager.retrieveStudentListFromSharedPreferences(context = this)
        }
    }
private fun setUpFilter() {
    val editText = findViewById<EditText>(R.id.textInputFilter)

    editText.doAfterTextChanged {
        students = if (editText.text.isEmpty()) {
            studentsManager.retrieveStudentListFromSharedPreferences(this)
        } else {
            students.filter { student -> student.name.contains( editText.text.toString() )  }.toMutableList()
        }

        adapter = StudentAdapter(students)
        binding.recyclerStudent.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
    private fun addStudents10AskedDueRequirements() {
        val studentList = mutableListOf(Student("Maria", age = "10", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("pedro", age = "43", photo = "https://img.freepik.com/free-photo/medium-shot-smiley-kids-posing-together_23-2149073581.jpg?size=626&ext=jpg"),
            Student("Zad", age = "43", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Calor", age = "53", photo = "https://img.freepik.com/free-photo/medium-shot-smiley-kids-posing-together_23-2149073581.jpg?size=626&ext=jpg"),
            Student("Candela", age = "43", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Yeison", age = "3", photo = "https://www.shutterstock.com/image-photo/happy-student-taking-notes-while-260nw-1860471403.jpg"),
            Student("Ronaldo", age = "2", photo = "https://img.freepik.com/free-photo/little-boy-having-idea_23-2149352405.jpg?w=1800&t=st=1684638033~exp=1684638633~hmac=930f7044b3c41c2c24d6a54d87b11d3e3f77860affae60a2d9fafd317f895463"),
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
        if (studentsManager.retrieveStudentListFromSharedPreferences(context = this).isEmpty() || students.isEmpty()) {
            addStudents10AskedDueRequirements()
        }
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