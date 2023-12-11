package com.example.md_final_project_louis_bessard

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val maidenName: String?,
    val age: Int?,
    val gender: String?,
    val email: String?,
    val phone: String?,
    val username: String?,
    val password: String?,
    val birthDate: String?,
    val image: String?,
    val bloodGroup: String?,
    val height: Int?,
    val weight: Double?,
    val eyeColor: String?,
    val hair: Hair?,
    val domain: String?,
    val ip: String?,
    val address: Address?,
    val macAddress: String?,
    val university: String?,
    val bank: Bank?,
    val company: Company?,
    val ein: String?,
    val ssn: String?,
    val userAgent: String?
) {
    fun toUser(): User {
        val fullName = "${firstName.orEmpty()} ${lastName.orEmpty()}".trim()
        return User(fullName, email.orEmpty(), (age ?: 0).toString())
    }
}

@Serializable
data class Hair(
    val color: String?,
    val type: String?
)

@Serializable
data class Address(
    val address: String?,
    val city: String?,
    val coordinates: Coordinates?,
    val postalCode: String?,
    val state: String?
)

@Serializable
data class Coordinates(
    val lat: Double?,
    val lng: Double?
)

@Serializable
data class Bank(
    val cardExpire: String?,
    val cardNumber: String?,
    val cardType: String?,
    val currency: String?,
    val iban: String?
)

@Serializable
data class Company(
    val address: Address?,
    val department: String?,
    val name: String?,
    val title: String?
)

@Serializable
data class SimplifiedUserDTO(
    val name: String,
    val email: String,
    val age: Int
)
