package com.adedom.todolist.models.request

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
@KtorExperimentalLocationsAPI
@Location("/api/todolist/remove-todolist/{todolistId}")
data class RemoveTodolistRequest(
    val todolistId: String? = null,
)
