package com.jr.usersretrofit.data.remote
import com.jr.usersretrofit.data.remote.dto.UsersResponseDto
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UsersApi {
    companion object {
        val instance = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(UsersApi::class.java)
    }

    @GET("users")
    suspend fun getUsers(): UsersResponseDto
}
