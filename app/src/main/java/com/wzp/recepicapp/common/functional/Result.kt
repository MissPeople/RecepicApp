package com.wzp.recepicapp.common.functional

sealed class Result<out S> {
    data class Success<S>(val data: S?) : Result<S>()
    data class Loading(val percentage: Int?) : Result<Nothing>()
    data class Exception(val failure: Failure) : Result<Nothing>() {
        interface Failure
    }
}

data class Unexpected(val errorMessage: String?) : Result.Exception.Failure