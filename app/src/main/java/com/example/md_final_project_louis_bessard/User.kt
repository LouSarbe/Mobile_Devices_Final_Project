package com.example.md_final_project_louis_bessard

// User.kt
import kotlinx.serialization.Serializable

@Serializable
class User(
    var name: String?,
    var email: String?,
    var age: String?
)