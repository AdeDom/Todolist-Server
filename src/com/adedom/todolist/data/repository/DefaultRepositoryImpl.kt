package com.adedom.todolist.data.repository

import com.adedom.todolist.data.mapper.Mapper
import com.adedom.todolist.data.model.TodolistDb
import com.adedom.todolist.data.table.TodoLists
import com.adedom.todolist.models.request.AddTodolistRequest
import com.adedom.todolist.models.request.ChangeTodolistRequest
import io.ktor.locations.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

@KtorExperimentalLocationsAPI
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

    override fun addTodolist(userId: String, addTodolistRequest: AddTodolistRequest): Boolean {
        val (todolistId, title, content) = addTodolistRequest

        val statement = transaction {
            TodoLists.insert {
                it[TodoLists.todolistId] = todolistId!!
                it[TodoLists.userId] = userId
                it[TodoLists.title] = title!!
                it[TodoLists.content] = content!!
                it[TodoLists.created] = System.currentTimeMillis()
                it[TodoLists.isShow] = true
            }
        }

        return statement.resultedValues?.size == 1
    }

    override fun changeTodolist(changeTodolistRequest: ChangeTodolistRequest): Boolean {
        val (todolistId, title, content) = changeTodolistRequest

        val result = transaction {
            TodoLists.update({ TodoLists.todolistId eq todolistId!! }) {
                it[TodoLists.title] = title!!
                it[TodoLists.content] = content!!
                it[TodoLists.updated] = System.currentTimeMillis()
            }
        }

        return result == 1
    }

}
