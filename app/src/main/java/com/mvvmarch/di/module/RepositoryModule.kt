package com.mvvmarch.di.module

import com.mvvmarch.data.remote.repository.IUserRepository
import com.mvvmarch.data.remote.repository.UserRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        single { UserRepositoryImpl(get(), get()) } bind IUserRepository::class
    }
}