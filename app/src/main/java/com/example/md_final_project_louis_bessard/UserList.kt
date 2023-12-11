package com.example.md_final_project_louis_bessard

//UserList.kt
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope

class UserList : Fragment(R.layout.fragment_user_list) {
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper
    private lateinit var userAdapter: UserAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userService = UserService(requireContext())

        sharedPreferenceHelper = SharedPreferenceHelper(requireContext())
        userAdapter = UserAdapter(sharedPreferenceHelper.getUserList())

        val recyclerView = view.findViewById<RecyclerView>(R.id.user_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = userAdapter

        fetchUsersAndUpdateUI(userService)
        displayUserList()

        view.findViewById<Button>(R.id.userList_to_home_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_mainFragment)
        }

        view.findViewById<Button>(R.id.userList_to_forms_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_formsFragment)
        }
    }

    private fun displayUserList() {
        userAdapter = UserAdapter(sharedPreferenceHelper.getUserList())
        val recyclerView = view?.findViewById<RecyclerView>(R.id.user_list_recycler_view)
        recyclerView?.adapter = userAdapter
    }

    private fun fetchUsersAndUpdateUI(userService : UserService) {
        lifecycleScope.launch {
            try {
                val usersDTO = userService.service.getUsers() // exception here
                val users = usersDTO.map { it.toUser() }

                userService.saveUsersToSharedPreferences(users)
            } catch (e: Exception) {
                // Handle exceptions or errors here
            }
        }
    }
}