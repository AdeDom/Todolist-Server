package com.adedom.todolist.business.todolist

import com.adedom.todolist.business.default.DefaultBusiness
import com.adedom.todolist.business.model.TodolistAll
import com.adedom.todolist.data.repository.DefaultRepository
import com.adedom.todolist.models.response.TodolistAllResponse

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

}
