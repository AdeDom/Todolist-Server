package com.adedom.todolist.models.request

import io.ktor.locations.*
import kotlinx.serialization.Serializable

@Serializable
@KtorExperimentalLocationsAPI
@Location("/api/todolist/todolist-all")
class TodolistAllRequest
