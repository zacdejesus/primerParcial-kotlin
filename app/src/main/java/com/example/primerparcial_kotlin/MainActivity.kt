package com.example.primerparcial_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.adapter.StudentAdapter
import com.example.primerparcial_kotlin.models.Student
import com.example.primerparcial_kotlin.viewModels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel = MainActivityViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODOO -> delete later harcoded students
        val studentList = listOf(Student("Jose"), Student("zad"), Student("Maria"))
        viewModel.saveStudentListToSharedPreferences(this,studentList)

        initRecyclerView()
    }



    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerStudent)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(viewModel.retrieveStudentListFromSharedPreferences(this))
    }
}