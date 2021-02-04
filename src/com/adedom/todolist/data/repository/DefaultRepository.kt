package com.adedom.todolist.data.repository

import com.adedom.todolist.data.model.TodolistDb
import com.adedom.todolist.models.request.AddTodolistRequest
import com.adedom.todolist.models.request.ChangeTodolistRequest
import com.adedom.todolist.models.request.RemoveTodolistRequest
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
internal interface DefaultRepository {

    fun getTodolistAll(): List<TodolistDb>

    fun addTodolist(userId: String, addTodolistRequest: AddTodolistRequest): Boolean

    fun changeTodolist(changeTodolistRequest: ChangeTodolistRequest): Boolean

    fun removeTodolist(removeTodolistRequest: RemoveTodolistRequest): Boolean

}
