package com.example.primerparcial_kotlin.viewModels

import android.content.Context
import com.example.primerparcial_kotlin.models.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivityViewModel {
    fun saveStudentListToSharedPreferences(context: Context, studentList: List<Student>) {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val studentListJson = gson.toJson(studentList)
        sharedPreferences.edit().putString("studentListKey", studentListJson).apply()
    }

    fun retrieveStudentListFromSharedPreferences(context: Context): List<Student> {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val studentListJson = sharedPreferences.getString("studentListKey", null)
        val gson = Gson()
        return gson.fromJson(studentListJson, object : TypeToken<List<Student>>() {}.type)
    }
}