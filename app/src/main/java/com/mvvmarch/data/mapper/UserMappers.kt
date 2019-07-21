package com.mvvmarch.data.mapper

import com.mvvmarch.data.local.database.entity.UserLocalEntity
import com.mvvmarch.data.remote.entity.UserResponseEntity

fun UserResponseEntity.toLocalEntity() = UserLocalEntity(
    gender = gender,
    name = name,
    region = region,
    surname = surname
)

fun UserLocalEntity.toRemoteEntity() = UserResponseEntity(
    gender,
    name,
    region,
    surname
)