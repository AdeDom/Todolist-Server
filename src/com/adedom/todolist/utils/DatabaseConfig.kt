package com.adedom.todolist.utils

object DatabaseConfig {

    object Localhost {
        private const val databaseName: String = "todolist"
        const val username: String = "root"
        const val password: String = "abc456"
        const val jdbcUrl: String = "jdbc:mysql://192.168.43.22:3306/$databaseName"
    }

    object Cleardb {
        private const val databaseName: String = "heroku_cd77525b5741689"
        const val username: String = "b44a9ebf35f59f"
        const val password: String = "2cfb4300"
        const val jdbcUrl: String =
            "jdbc:mysql://$username:$password@eu-cdbr-west-03.cleardb.net/$databaseName?reconnect=true"
    }

}
