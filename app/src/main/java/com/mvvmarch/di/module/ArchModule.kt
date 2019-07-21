package com.mvvmarch.di.module

import com.mvvmarch.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ArchModule {
    val module = module {
        viewModel { MainViewModel(get()) }
    }
}