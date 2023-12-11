package com.example.md_final_project_louis_bessard

// User.kt
import kotlinx.serialization.Serializable

@Serializable
class User(
    var name: String?,
    var email: String?,
    var age: String?
) {
    fun toMap(): Map<String, String> {
        val userMap = mutableMapOf<String, String>()
        userMap["name"] = this.name ?: ""
        userMap["email"] = this.email ?: ""
        userMap["age"] = this.age ?: ""
        return userMap
    }
}