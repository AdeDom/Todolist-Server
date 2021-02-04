package com.adedom.todolist.data.model

internal data class TodolistDb(
    val todolistId: String,
    val userId: String,
    val title: String,
    val content: String,
    val created: Long,
    val updated: Long?,
    val isShow: Boolean,
)
