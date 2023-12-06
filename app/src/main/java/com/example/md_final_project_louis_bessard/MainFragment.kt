import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.md_final_project_louis_bessard.R
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_to_forms_button).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_formsFragment)
        }

        view.findViewById<Button>(R.id.go_to_users_button).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_userList)
        }
    }
}
