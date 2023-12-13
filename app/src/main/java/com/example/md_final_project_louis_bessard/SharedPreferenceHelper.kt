package com.example.md_final_project_louis_bessard

//SharedPreferenceHelper.kt
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SharedPreferenceHelper(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        "myPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUser(user: User) {
        val userJson = gson.toJson(user)
        val editor = sharedPreferences.edit()
        editor.putString("user_${System.currentTimeMillis()}", userJson)
        editor.apply()
    }

    fun getUserList(): List<User> {
        val allEntries = sharedPreferences.all
        val userList = mutableListOf<User>()
        for ((_, value) in allEntries) {
            val json = value as String
            val user = gson.fromJson(json, User::class.java)
            userList.add(user)
        }
        return userList
    }
}
