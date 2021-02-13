package com.adedom.todolist.data.mapper

import com.adedom.todolist.data.model.TodolistDb
import com.adedom.todolist.data.table.TodoLists
import io.ktor.util.*
import org.jetbrains.exposed.sql.ResultRow

@InternalAPI
internal class Mapper {

    fun toTodoListDb(row: ResultRow) = TodolistDb(
        todolistId = row[TodoLists.todolistId],
        userId = row[TodoLists.userId],
        title = row[TodoLists.title].decodeBase64String(),
        content = row[TodoLists.content].decodeBase64String(),
        created = row[TodoLists.created],
        updated = row[TodoLists.updated],
        isShow = row[TodoLists.isShow],
    )

}
