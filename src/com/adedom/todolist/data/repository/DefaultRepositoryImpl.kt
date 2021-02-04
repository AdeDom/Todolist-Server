package com.adedom.todolist.data.repository

import com.adedom.todolist.data.mapper.Mapper
import com.adedom.todolist.data.model.TodolistDb
import com.adedom.todolist.data.table.TodoLists
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

internal class DefaultRepositoryImpl(
    private val mapper: Mapper,
) : DefaultRepository {

    override fun getTodolistAll(): List<TodolistDb> {
        return transaction {
            TodoLists
                .slice(
                    TodoLists.todolistId,
                    TodoLists.userId,
                    TodoLists.title,
                    TodoLists.content,
                    TodoLists.created,
                    TodoLists.updated,
                    TodoLists.isShow,
                )
                .select { TodoLists.isShow eq true }
                .map { mapper.toTodoListDb(it) }
        }
    }

}
