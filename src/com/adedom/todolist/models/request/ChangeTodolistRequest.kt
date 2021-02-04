package com.adedom.todolist.models.request

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
@KtorExperimentalLocationsAPI
@Location("/api/todolist/change-todolist")
data class ChangeTodolistRequest(
    val todolistId: String? = null,
    val title: String? = null,
    val content: String? = null,
)
