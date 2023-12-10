package com.example.md_final_project_louis_bessard

// UserActivity.kt
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = userAdapter

        displayUserList()
    }

    private fun displayUserList() {
        userAdapter = UserAdapter(sharedPreferenceHelper.getUserList())
        val recyclerView = findViewById<RecyclerView>(R.id.user_list_recycler_view)
        recyclerView.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()
        displayUserList()
    }
}