package com.mvvmarch.ui.main

import com.mvvmarch.base.BaseViewModel
import com.mvvmarch.data.remote.repository.IUserRepository

class MainViewModel(
    private val userRepository: IUserRepository
) : BaseViewModel() {

}