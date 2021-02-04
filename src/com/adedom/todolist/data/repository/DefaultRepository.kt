package com.adedom.todolist.data.repository

import com.adedom.todolist.data.model.TodolistDb

internal interface DefaultRepository {

    fun getTodolistAll(): List<TodolistDb>

}
