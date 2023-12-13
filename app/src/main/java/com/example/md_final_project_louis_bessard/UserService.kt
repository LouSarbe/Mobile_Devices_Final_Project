package com.example.md_final_project_louis_bessard

// UserService.kt
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.MediaType.Companion.toMediaType

class UserService(private val context: Context) {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val PREF_NAME = "myPrefs"
    private val json = Json { ignoreUnknownKeys = true }
    private val gson = Gson()

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL).build()

    interface UserApi {
        @GET("/users")
        suspend fun getUsers(): List<UserDTO>
    }

    val service: UserApi = retrofit.create(UserApi::class.java)

    fun saveUsersToSharedPreferences(users: List<User>) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        for ((index,user) in users.withIndex()) {
            val userJson = gson.toJson(user)
            editor.putString("user_${System.currentTimeMillis()}", userJson)
            editor.apply()
        }
    }
}