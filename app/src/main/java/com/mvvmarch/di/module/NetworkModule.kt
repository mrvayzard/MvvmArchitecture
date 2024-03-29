package com.mvvmarch.di.module

import android.location.Geocoder
import com.mvvmarch.BuildConfig
import com.mvvmarch.data.remote.ApiService
import com.mvvmarch.data.remote.interceptor.ConnectivityInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {
    val module = module {
        single { createOkHttpClient(get()) }
        single { createRetrofitInstance(get()) }
        single { createApiService(get()) }
        single { Geocoder(androidContext()) }
        single { ConnectivityInterceptor(androidContext()) }
    }

    private fun createOkHttpClient(
        connectivityInterceptor: ConnectivityInterceptor
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val builder = OkHttpClient.Builder()
            .addInterceptor(connectivityInterceptor)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    private fun createRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.MAIN_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private fun createApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}