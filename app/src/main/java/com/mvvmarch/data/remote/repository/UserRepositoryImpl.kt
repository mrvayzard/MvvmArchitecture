package com.mvvmarch.data.remote.repository

import com.mvvmarch.data.Result
import com.mvvmarch.data.local.database.dao.UserDao
import com.mvvmarch.data.local.database.entity.UserLocalEntity
import com.mvvmarch.data.mapTo
import com.mvvmarch.data.mapper.toLocalEntity
import com.mvvmarch.data.remote.ApiService
import com.mvvmarch.data.remote.entity.UserResponseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val api: ApiService,
    private val userDao: UserDao
) : IUserRepository, BaseRepository() {
    override suspend fun getRandomUserName(): Result<String> = withContext(Dispatchers.IO) {
        processRequest {
            api.getRandomUser()
        }.mapTo { it.name }
    }

    override suspend fun addUserToDB(user: UserResponseEntity) = withContext(Dispatchers.IO) {
        userDao.add(user.toLocalEntity())
    }

    override suspend fun updateUserInDB(user: UserLocalEntity) = withContext(Dispatchers.IO) {
        userDao.update(user)
    }
}