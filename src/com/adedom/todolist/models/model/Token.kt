package com.adedom.todolist.models.model

import kotlinx.serialization.Serializable

@Serializable
data class Token(
    val accessToken: String? = null,
    val refreshToken: String? = null,
)
