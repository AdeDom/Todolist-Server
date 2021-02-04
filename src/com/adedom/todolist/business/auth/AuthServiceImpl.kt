package com.adedom.todolist.business.auth

import com.adedom.todolist.models.request.SignInRequest
import com.adedom.todolist.models.response.SignInResponse
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
internal class AuthServiceImpl : AuthService {

    override fun signIn(signInRequest: SignInRequest): SignInResponse {
        val response = SignInResponse(message = signInRequest.toString())
        return response
    }

}
