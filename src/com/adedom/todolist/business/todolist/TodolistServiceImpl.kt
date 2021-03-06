package com.adedom.todolist.business.todolist

import com.adedom.todolist.business.default.DefaultBusiness
import com.adedom.todolist.business.model.TodolistAll
import com.adedom.todolist.data.repository.DefaultRepository
import com.adedom.todolist.models.request.AddTodolistRequest
import com.adedom.todolist.models.request.ChangeTodolistRequest
import com.adedom.todolist.models.request.RemoveTodolistRequest
import com.adedom.todolist.models.response.BaseResponse
import com.adedom.todolist.models.response.TodolistAllResponse
import io.ktor.locations.*

@KtorExperimentalLocationsAPI
internal class TodolistServiceImpl(
    private val repository: DefaultRepository,
    private val business: DefaultBusiness,
) : TodolistService {

    override fun getTodolistAll(): TodolistAllResponse {
        val response = TodolistAllResponse()

        val message: String = when {
            // validate Null Or Blank

            // validate values of variable

            // validate database

            // execute
            else -> {
                val todolistAll = repository.getTodolistAll().map {
                    TodolistAll(
                        todolistId = it.todolistId,
                        userId = it.userId,
                        title = it.title,
                        content = it.content,
                        createdLong = it.created,
                        updatedLong = it.updated,
                        createdString = business.getDateTimeLongToString(it.created),
                        updatedString = business.getDateTimeLongToString(it.updated),
                        isShow = it.isShow,
                    )
                }
                response.todolistAll = todolistAll
                response.success = true
                "Fetch todolist all success"
            }
        }

        response.message = message
        return response
    }

    override fun addTodolist(userId: String?, addTodolistRequest: AddTodolistRequest): BaseResponse {
        val response = BaseResponse()
        val (todolistId, title, content) = addTodolistRequest

        val message: String = when {
            // validate Null Or Blank
            userId.isNullOrBlank() -> "userId isNullOrBlank"
            todolistId.isNullOrBlank() -> "todolistId isNullOrBlank"
            title.isNullOrBlank() -> "title isNullOrBlank"
            content.isNullOrBlank() -> "content isNullOrBlank"

            // validate values of variable

            // validate database

            // execute
            else -> {
                response.success = repository.addTodolist(userId, addTodolistRequest)
                "Add todolist success"
            }
        }

        response.message = message
        return response
    }

    override fun changeTodolist(changeTodolistRequest: ChangeTodolistRequest): BaseResponse {
        val response = BaseResponse()
        val (todolistId, title, content) = changeTodolistRequest

        val message: String = when {
            // validate Null Or Blank
            todolistId.isNullOrBlank() -> "todolistId isNullOrBlank"
            title.isNullOrBlank() -> "title isNullOrBlank"
            content.isNullOrBlank() -> "content isNullOrBlank"

            // validate values of variable

            // validate database

            // execute
            else -> {
                response.success = repository.changeTodolist(changeTodolistRequest)
                "Change todolist success"
            }
        }

        response.message = message
        return response
    }

    override fun removeTodolist(removeTodolistRequest: RemoveTodolistRequest): BaseResponse {
        val response = BaseResponse()
        val (todolistId) = removeTodolistRequest

        val message: String = when {
            // validate Null Or Blank
            todolistId.isNullOrBlank() -> "todolistId isNullOrBlank"

            // validate values of variable

            // validate database

            // execute
            else -> {
                response.success = repository.removeTodolist(removeTodolistRequest)
                "Remove todolist success"
            }
        }

        response.message = message
        return response
    }

}
