package com.example.md_final_project_louis_bessard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FormsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_forms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submit_button.setOnClickListener {
            // Collect form data
            val inputData = collectFormData()

            // Pass data to UsersFragment
            val usersFragment = UsersFragment.newInstance(inputData)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, usersFragment)
                ?.addToBackStack(null)
                ?.commit()
        }
    }

    private fun collectFormData(): Map<String, String> {
        // Retrieve form data and convert it into a map
        val formData = mutableMapOf<String, String>()

        // Example: Getting data from EditText fields
        formData["name"] = name_edit_text.text.toString()
        formData["email"] = email_edit_text.text.toString()
        formData["age"] = age_edit_text.text.toString()
        // Add other form fields as needed

        return formData
    }
}
