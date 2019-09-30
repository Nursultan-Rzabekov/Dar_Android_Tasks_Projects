package com.example.cleanarhitecturewithmvp.exceptions


class ReposRefreshError(cause: Throwable) : Throwable(cause.message, cause)