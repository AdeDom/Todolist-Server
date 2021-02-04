package com.adedom.todolist.data.table

import org.jetbrains.exposed.sql.Table

internal object TodoLists : Table(name = "todolist") {

    val todolistId = varchar("todolist_id", length = 50)
    val userId = varchar("user_id", length = 50)
    val title = varchar("title", length = 1_000)
    val content = varchar("content", length = 10_000)
    val created = long("created")
    val updated = long("updated").nullable()
    val isShow = bool("is_show")

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(todolistId, name = "PK_Todolist_ID")

}
