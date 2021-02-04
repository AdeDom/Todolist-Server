package com.adedom.todolist.models.request

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
@KtorExperimentalLocationsAPI
@Location("/api/todolist/add-todolist")
data class AddTodolistRequest(
    val todolistId: String? = null,
    val title: String? = null,
    val content: String? = null,
)
