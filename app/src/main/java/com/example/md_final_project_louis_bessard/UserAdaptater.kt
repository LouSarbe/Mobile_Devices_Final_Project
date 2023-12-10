package com.example.md_final_project_louis_bessard

// UserAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserHolder>() {

    inner class UserHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val userName: TextView = view.findViewById(R.id.name_text_view)
        private val userEmail: TextView = view.findViewById(R.id.email_text_view)
        private val userAge: TextView = view.findViewById(R.id.age_text_view)

        fun onBind(data: User) {
            userName.text = data.name
            userEmail.text = data.email
            userAge.text = data.age
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.user_holder, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.onBind(users[position])
    }
}
