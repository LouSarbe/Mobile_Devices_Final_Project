package com.example.md_final_project_louis_bessard

// UserService.kt
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.MediaType.Companion.toMediaType

class UserService {
    private val BASE_URL = "https://dummyjson.com/"

    /**
     * We don't want all data, so ignore the unknown keys
     */
    private val json = Json {ignoreUnknownKeys = true}

    /**
     * A retrofit instance, with a client http and a converter.
     * Will transform the JSON into object thanks to kotlin serialization.
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL).build()

    interface UserApi {
        @GET("/users")
        suspend fun getUsers() : List<User>
    }

    /**
     * Retrofit transform the interface (and his annotations) into a class.
     * See [com.enioka.robotapp.ui.users.UserViewModel]
     */
    val service: UserApi = retrofit.create(UserApi::class.java)
}