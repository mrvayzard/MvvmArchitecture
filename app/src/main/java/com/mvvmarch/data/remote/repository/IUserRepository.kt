package com.mvvmarch.data.remote.repository

import com.mvvmarch.data.Result
import com.mvvmarch.data.local.database.entity.UserLocalEntity
import com.mvvmarch.data.remote.entity.UserResponseEntity

interface IUserRepository {
    suspend fun getRandomUserName(): Result<String>
    suspend fun addUserToDB(user: UserResponseEntity): Long
    suspend fun updateUserInDB(user: UserLocalEntity)
}