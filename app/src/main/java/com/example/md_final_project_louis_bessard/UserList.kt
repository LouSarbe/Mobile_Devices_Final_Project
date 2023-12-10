package com.example.md_final_project_louis_bessard

// UserList.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class UserList : Fragment(R.layout.fragment_user_list) {
    private lateinit var adapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.userList_to_home_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_mainFragment)
        }

        view.findViewById<Button>(R.id.userList_to_forms_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_formsFragment)
        }
    }
}

