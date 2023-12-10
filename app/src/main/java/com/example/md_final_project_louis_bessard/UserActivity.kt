package com.example.md_final_project_louis_bessard

// UserActivity.kt
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class UserActivity : AppCompatActivity() {
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_holder)

        sharedPreferenceHelper = SharedPreferenceHelper(this)
        userAdapter = UserAdapter(sharedPreferenceHelper.getUserList())

        val recyclerView = supportFragmentManager.findFragmentById(R.id.fragment_user_list)
            ?.view?.findViewById<RecyclerView>(R.id.user_list_recycler_view)
        val submitButton = supportFragmentManager.findFragmentById(R.id.fragment_forms)
            ?.view?.findViewById<Button>(R.id.submit_button)

        submitButton?.setOnClickListener {
            val name = supportFragmentManager.findFragmentById(R.id.fragment_forms)
                ?.view?.findViewById<TextInputEditText>(R.id.name_edit_text)?.text.toString()
            val email = supportFragmentManager.findFragmentById(R.id.fragment_forms)
                ?.view?.findViewById<TextInputEditText>(R.id.email_edit_text)?.text.toString()
            val age = supportFragmentManager.findFragmentById(R.id.fragment_forms)
                ?.view?.findViewById<TextInputEditText>(R.id.age_edit_text)?.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && age.isNotEmpty()) {
                val newUser = User(name, email, age)
                sharedPreferenceHelper.saveUser(newUser)
                displayUserList()
                clearForm()
            } else {
                // Handle input validation error
            }
        }

        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = userAdapter

        displayUserList()
    }

    private fun displayUserList() {
        userAdapter = UserAdapter(sharedPreferenceHelper.getUserList())
        val recyclerView = findViewById<RecyclerView>(R.id.user_list_recycler_view)
        recyclerView.adapter = userAdapter
    }

    private fun clearForm() {
        findViewById<TextInputEditText>(R.id.name_edit_text).text?.clear()
        findViewById<TextInputEditText>(R.id.email_edit_text).text?.clear()
        findViewById<TextInputEditText>(R.id.age_edit_text).text?.clear()
    }
}