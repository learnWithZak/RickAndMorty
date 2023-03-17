package com.zak.rickandmorty.service

import com.zak.rickandmorty.service.ApiResponse.Status.ERROR
import com.zak.rickandmorty.service.ApiResponse.Status.SUCCESS
import retrofit2.HttpException
import retrofit2.Response

class ApiResponse<T>(val status: Status,
                     val data: T?,
                     val errorMessage: String? = null,
                     val errorCode: Int? = null) {

	enum class Status {
		SUCCESS, ERROR, LOADING
	}

	companion object {
		fun <T> success(data: T): ApiResponse<T> {
			return ApiResponse(SUCCESS, data)
		}

		fun <T> error(message: String?, code: Int, data: T? = null): ApiResponse<T> {
			return ApiResponse(ERROR, data, message, code)
		}
	}
}

suspend fun <T : Any> handleApiResponse(execute: suspend () -> Response<T>): ApiResponse<T> {
	return try {
		val response = execute()
		val body = response.body()
		if (response.isSuccessful && body != null) {
			ApiResponse.success(body)
		} else {
			ApiResponse.error(message = response.message(), code = response.code())
		}
	} catch (e: HttpException) {
		ApiResponse.error(message = e.message(), code = e.code())
	} catch (e: Exception) {
		ApiResponse.error(message = e.message, code = e.hashCode())
	}
}