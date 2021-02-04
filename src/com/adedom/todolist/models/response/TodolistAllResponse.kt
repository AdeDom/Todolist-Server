package com.adedom.todolist.models.response

import com.adedom.todolist.business.model.TodolistAll
import kotlinx.serialization.Serializable

@Serializable
data class TodolistAllResponse(
    var success: Boolean = false,
    var message: String? = null,
    var todolistAll: List<TodolistAll> = emptyList(),
)
