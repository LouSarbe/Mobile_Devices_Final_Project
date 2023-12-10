package com.example.md_final_project_louis_bessard

// FormsFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class FormsFragment : Fragment(R.layout.fragment_forms) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.forms_to_home_button).setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_mainFragment)
        }

        view.findViewById<Button>(R.id.forms_to_userList_button).setOnClickListener {
            findNavController().navigate(R.id.action_formsFragment_to_userList)
        }
    }
}
