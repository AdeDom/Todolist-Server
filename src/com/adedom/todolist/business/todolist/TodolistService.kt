package com.adedom.todolist.business.todolist

import com.adedom.todolist.models.request.AddTodolistRequest
import com.adedom.todolist.models.request.ChangeTodolistRequest
import com.adedom.todolist.models.response.BaseResponse
import com.adedom.todolist.models.response.TodolistAllResponse
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
internal interface TodolistService {

    fun getTodolistAll(): TodolistAllResponse

    fun addTodolist(userId: String?, addTodolistRequest: AddTodolistRequest): BaseResponse

    fun changeTodolist(changeTodolistRequest: ChangeTodolistRequest): BaseResponse

}
