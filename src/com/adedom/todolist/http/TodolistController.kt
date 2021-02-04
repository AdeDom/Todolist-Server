package com.adedom.todolist.http

import com.adedom.todolist.business.todolist.TodolistService
import com.adedom.todolist.models.request.TodolistAllRequest
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
internal fun Route.todolistController(service: TodolistService) {

    get<TodolistAllRequest> {
        val response = service.getTodolistAll()
        call.respond(response)
    }

}
