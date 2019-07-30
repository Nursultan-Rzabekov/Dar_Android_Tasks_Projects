package com.example.kotlincoroutines

open class DataSourceException(message: String? = null) : Exception(message)

class RemoteDataNotFoundException : DataSourceException("Data not found in remote data source")

class ReposRefreshError(cause: Throwable) : Throwable(cause.message, cause)
