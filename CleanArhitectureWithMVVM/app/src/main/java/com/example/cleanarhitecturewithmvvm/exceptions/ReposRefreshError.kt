package com.example.cleanarhitecturewithmvvm.exceptions


class ReposRefreshError(cause: Throwable) : Throwable(cause.message, cause)