package com.adedom.todolist.utils

object DatabaseConfig {

    object Localhost {
        private const val databaseName: String = "todolist"
        const val username: String = "root"
        const val password: String = "abc456"
        const val jdbcUrl: String = "jdbc:mysql://192.168.43.22:3306/$databaseName"
    }

}
