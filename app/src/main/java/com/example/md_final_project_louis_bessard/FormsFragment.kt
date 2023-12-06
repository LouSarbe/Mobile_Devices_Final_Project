package com.example.md_final_project_louis_bessard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class FormsFragment : Fragment(R.layout.fragment_forms) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.forms_to_home_button).setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_mainFragment)
        }

        view.findViewById<Button>(R.id.forms_to_userList_button).setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_userList)
        }

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            // Collect form data and create a User object
            val user = collectFormData()

            // Pass User data to UserList using arguments
            val userList = UserList.newInstance(user.toMap())
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, userList)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    private fun collectFormData(): User {
        val name = view?.findViewById<TextInputEditText>(R.id.name_edit_text)?.text.toString()
        val email = view?.findViewById<TextInputEditText>(R.id.email_edit_text)?.text.toString()
        val age = view?.findViewById<TextInputEditText>(R.id.age_edit_text)?.text.toString()

        return User(name, email, age)
    }
}
