package com.example.primerparcial_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.adapter.StudentAdapter
import com.example.primerparcial_kotlin.models.Student

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerStudent)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val students: List<Student> = listOf(Student(name = "Pedro"))
        recyclerView.adapter = StudentAdapter(students)
    }
}