package com.adedom.todolist.business.auth

import com.adedom.todolist.models.request.SignInRequest
import com.adedom.todolist.models.response.SignInResponse
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
internal interface AuthService {

    fun signIn(signInRequest: SignInRequest): SignInResponse

}
