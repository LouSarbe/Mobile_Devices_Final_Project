package com.example.md_final_project_louis_bessard

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class UserDTO(
    val name: String?,
    val email: String?
) {
    fun toUser(): User {
        return User(name, email.orEmpty(), Random.nextInt(15, 66).toString())
    }
}
