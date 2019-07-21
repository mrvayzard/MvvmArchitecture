package com.mvvmarch.data.remote.interceptor

import android.content.Context
import com.mvvmarch.base.exception.NoInternetException
import com.mvvmarch.util.NetworkUtil
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(
    private val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isNetworkConnected(context)) {
            throw NoInternetException()
        }

        return chain.proceed(chain.request())
    }
}