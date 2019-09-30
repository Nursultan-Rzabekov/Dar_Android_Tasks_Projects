package com.example.kotlinarhitecturecomponents.exceptions


class ReposRefreshError(cause: Throwable) : Throwable(cause.message, cause)