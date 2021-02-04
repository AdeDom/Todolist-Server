package com.adedom.todolist.http

import com.adedom.todolist.business.auth.AuthService
import com.adedom.todolist.models.request.SignInRequest
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
internal fun Route.authController(service: AuthService) {

    post<SignInRequest> {
        val request = call.receive<SignInRequest>()
        val response = service.signIn(request)
        call.respond(response)
    }

}
