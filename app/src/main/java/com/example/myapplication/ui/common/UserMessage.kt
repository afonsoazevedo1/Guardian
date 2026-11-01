package com.example.myapplication.ui.common

import androidx.annotation.StringRes

data class UserMessage(
    @StringRes val messageRes: Int,
    val isError: Boolean = false,
    val formatArgs: List<Any> = emptyList()
)
