package com.example.md_final_project_louis_bessard

class User {
    var name: String? = null
    var email: String? = null
    var age: String? = null

    constructor(name: String?, email: String?, age: String?) {
        this.name = name
        this.email = email
        this.age = age
    }

    fun toMap(): Map<String, String> {
        val userMap = mutableMapOf<String, String>()
        userMap["name"] = this.name!!
        userMap["email"] = this.email!!
        userMap["age"] = this.age!!
        return userMap
    }
}