package com.adedom.todolist.models.response

import com.adedom.todolist.models.model.Token
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    var success: Boolean = false,
    var message: String? = null,
    var token: Token? = null,
    var isUpdateProfile: Boolean = false,
)
