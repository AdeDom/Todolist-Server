package com.adedom.todolist

import com.adedom.todolist.business.auth.AuthService
import com.adedom.todolist.business.di.getBusinessModule
import com.adedom.todolist.business.todolist.TodolistService
import com.adedom.todolist.data.di.getDataModule
import com.adedom.todolist.http.authController
import com.adedom.todolist.http.todolistController
import com.adedom.todolist.utils.DatabaseConfig
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.netty.*
import io.ktor.util.*
import org.jetbrains.exposed.sql.Database
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.logger.SLF4JLogger

fun main(args: Array<String>): Unit = EngineMain.main(args)

@InternalAPI
@KtorExperimentalLocationsAPI
fun Application.module() {

    // database mysql
    val databaseConfig = DatabaseConfig.Cleardb
    val config = HikariConfig().apply {
        jdbcUrl = databaseConfig.jdbcUrl
        driverClassName = "com.mysql.cj.jdbc.Driver"
        username = databaseConfig.username
        password = databaseConfig.password
        maximumPoolSize = 10
    }
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    // start project
    install(DefaultHeaders)
    install(CallLogging)

    // Cross-Origin Resource Sharing
    install(CORS) {
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        method(HttpMethod.Patch)
        method(HttpMethod.Delete)
        method(HttpMethod.Options)
        host(host = "localhost:8080", schemes = listOf("http"))
        host(host = "localhost:8081", schemes = listOf("http"))
        host(host = "todolist-web-94.herokuapp.com", schemes = listOf("https"))
        allowNonSimpleContentTypes = true
    }

    // json
    install(ContentNegotiation) {
        json()
    }

    // route location
    install(Locations)

    // koin dependencies injection
    install(Koin) {
        SLF4JLogger()
        modules(getBusinessModule, getDataModule)
    }
    val authService: AuthService by inject()
    val todolistService: TodolistService by inject()

    // route
    install(Routing) {
        authController(authService)
        todolistController(todolistService)
    }

}

internal fun getHttpClientApache() = HttpClient(Apache) {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }

    install(HttpTimeout) {
        requestTimeoutMillis = 60_000
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.HEADERS
    }
}
