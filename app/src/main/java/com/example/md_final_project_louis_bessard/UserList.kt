package com.example.md_final_project_louis_bessard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.InputStream

class UserList : Fragment(R.layout.fragment_user_list) {
    private lateinit var adapter: UserAdapter
    companion object {
        private const val INPUT_DATA_KEY = "inputData"

        fun newInstance(inputData: Map<String, String>): UserList {
            val fragment = UserList()
            val args = Bundle()
            args.putSerializable(INPUT_DATA_KEY, inputData as HashMap<String, String>)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.userList_to_home_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_mainFragment)
        }

        view.findViewById<Button>(R.id.userList_to_forms_button).setOnClickListener {
            findNavController().navigate(R.id.action_userList_to_formsFragment)
        }

        // Load and display data from a public JSON file
        //val jsonText = loadJSONFromAsset()
        //val jsonArray = JSONArray(jsonText)
        //json_data_text_view.text = jsonArray.toString()
    }

    private fun loadJSONFromAsset(): String {
        // Load JSON data from a public file in assets
        val json: String?
        try {
            val inputStream: InputStream = requireContext().assets.open("your_public_file.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}
