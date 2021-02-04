package com.adedom.todolist.http

import com.adedom.todolist.business.todolist.TodolistService
import com.adedom.todolist.models.request.AddTodolistRequest
import com.adedom.todolist.models.request.ChangeTodolistRequest
import com.adedom.todolist.models.request.RemoveTodolistRequest
import com.adedom.todolist.models.request.TodolistAllRequest
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
internal fun Route.todolistController(service: TodolistService) {

    get<TodolistAllRequest> {
        val response = service.getTodolistAll()
        call.respond(response)
    }

    post<AddTodolistRequest> {
        val userId: String? = "1122"
        val request = call.receive<AddTodolistRequest>()
        val response = service.addTodolist(userId, request)
        call.respond(response)
    }

    put<ChangeTodolistRequest> {
        val request = call.receive<ChangeTodolistRequest>()
        val response = service.changeTodolist(request)
        call.respond(response)
    }

    delete<RemoveTodolistRequest> { request ->
        val response = service.removeTodolist(request)
        call.respond(response)
    }

}
