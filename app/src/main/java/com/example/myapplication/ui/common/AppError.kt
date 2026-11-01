package com.example.myapplication.ui.common

sealed class AppError {
    object Network : AppError()
    object Timeout : AppError()
    object Unauthorized : AppError()
    object NotFound : AppError()
    object Conflict : AppError()
    data class InvalidData(val serverMessage: String? = null) : AppError()
    data class Server(val code: Int) : AppError()
    object Unknown : AppError()
}
