package com.example.primerparcial_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcial_kotlin.adapter.StudentAdapter
import com.example.primerparcial_kotlin.models.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODOO -> delete later harcoded students
        val studentList = listOf(Student("Jose"), Student("pablo"), Student("Maria"))
        saveStudentListToSharedPreferences(studentList)

        initRecyclerView()
    }

    fun saveStudentListToSharedPreferences(studentList: List<Student>) {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val studentListJson = gson.toJson(studentList)
        sharedPreferences.edit().putString("studentListKey", studentListJson).apply()
    }

    fun retrieveStudentListFromSharedPreferences(): List<Student> {
        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val studentListJson = sharedPreferences.getString("studentListKey", null)
        val gson = Gson()
        return gson.fromJson(studentListJson, object : TypeToken<List<Student>>() {}.type)
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerStudent)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(retrieveStudentListFromSharedPreferences())
    }
}