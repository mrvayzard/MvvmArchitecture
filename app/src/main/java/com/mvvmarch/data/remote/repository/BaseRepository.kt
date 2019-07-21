package com.mvvmarch.data.remote.repository

import com.mvvmarch.base.exception.ServerException
import com.mvvmarch.data.Result
import com.mvvmarch.data.ResultError
import com.mvvmarch.data.ResultSuccess
import retrofit2.Response

open class BaseRepository {
    suspend fun <T : Any> processRequest(call: suspend () -> Response<T>): Result<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) ResultSuccess(response.body()!!)
            else {
                // TODO: parse error codes
                ResultError(exception = ServerException())
            }
        } catch (ex: Exception) {
            ResultError(exception = ex)
        }
    }
}
