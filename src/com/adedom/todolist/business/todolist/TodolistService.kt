package com.adedom.todolist.business.todolist

import com.adedom.todolist.models.response.TodolistAllResponse

internal interface TodolistService {

    fun getTodolistAll(): TodolistAllResponse

}
