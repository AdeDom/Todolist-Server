package com.adedom.todolist.models.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    var success: Boolean = false,
    var message: String? = null,
)
