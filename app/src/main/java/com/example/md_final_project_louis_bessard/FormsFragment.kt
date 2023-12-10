package com.example.md_final_project_louis_bessard

// FormsFragment.kt
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class FormsFragment : Fragment(R.layout.fragment_forms) {
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferenceHelper = SharedPreferenceHelper(requireContext())

        val submitButton = view.findViewById<Button>(R.id.submit_button)
        submitButton.setOnClickListener {
            val name = view.findViewById<TextInputEditText>(R.id.name_edit_text).text.toString()
            print(name)
            val email = view.findViewById<TextInputEditText>(R.id.email_edit_text).text.toString()
            print(email)
            val age = view.findViewById<TextInputEditText>(R.id.age_edit_text).text.toString()
            print(age)

            if (name.isNotEmpty() && email.isNotEmpty() && age.isNotEmpty()) {
                val newUser = User(name, email, age)
                sharedPreferenceHelper.saveUser(newUser)
                clearForm(view)
            } else {
                // Handle input validation error
            }
        }

        val goToHomeButton = view.findViewById<Button>(R.id.forms_to_home_button)
        val goToUserListButton = view.findViewById<Button>(R.id.forms_to_userList_button)

        goToHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_mainFragment)
        }

        goToUserListButton.setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_userList)
        }
    }

    private fun clearForm(view: View) {
        view.findViewById<TextInputEditText>(R.id.name_edit_text).text?.clear()
        view.findViewById<TextInputEditText>(R.id.email_edit_text).text?.clear()
        view.findViewById<TextInputEditText>(R.id.age_edit_text).text?.clear()
    }
}
