package com.mvvmarch

import android.app.Application
import com.facebook.stetho.Stetho
import com.mvvmarch.di.module.ArchModule
import com.mvvmarch.di.module.DatabaseModule
import com.mvvmarch.di.module.NetworkModule
import com.mvvmarch.di.module.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }

        val moduleList = listOf(
            ArchModule.module,
            DatabaseModule.module,
            NetworkModule.module,
            RepositoryModule.module
        )
        startKoin {
            androidContext(this@BaseApplication)
            modules(moduleList)
        }

    }
}