package com.mvvmarch.data.remote

import com.mvvmarch.data.remote.entity.UserResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/api")
    suspend fun getRandomUser(): Response<UserResponseEntity>
}