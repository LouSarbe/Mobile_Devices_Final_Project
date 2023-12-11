package com.example.md_final_project_louis_bessard

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val age: Int?
) {
    fun toUser(): User {
        val fullName = "${firstName.orEmpty()} ${lastName.orEmpty()}".trim()
        return User(fullName, email, age?.toString())
    }
}