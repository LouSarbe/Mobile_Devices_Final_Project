package com.example.md_final_project_louis_bessard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.json.JSONArray
import java.io.InputStream

class UsersFragment : Fragment() {

    companion object {
        private const val INPUT_DATA_KEY = "inputData"

        fun newInstance(inputData: Map<String, String>): UsersFragment {
            val fragment = UsersFragment()
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
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve input data from bundle
        val inputData = arguments?.getSerializable(INPUT_DATA_KEY) as HashMap<String, String>?

        // Display input data in the UI
        inputData?.let {
            name_text_view.text = it["name"]
            email_text_view.text = it["email"]
            age_text_view.text = it["age"]
        }

        // Load and display data from a public JSON file
        val jsonText = loadJSONFromAsset()
        val jsonArray = JSONArray(jsonText)

        // Example: Displaying JSON data in a TextView
        json_data_text_view.text = jsonArray.toString()
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
