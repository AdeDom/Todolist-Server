package com.adedom.todolist.models.request

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
@KtorExperimentalLocationsAPI
@Location("/api/auth/sign-in")
data class SignInRequest(
    val serverAuthCode: String? = null,
)
