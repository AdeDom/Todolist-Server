package com.adedom.todolist.business.di

import com.adedom.todolist.business.auth.AuthService
import com.adedom.todolist.business.auth.AuthServiceImpl
import com.adedom.todolist.business.default.DefaultBusiness
import com.adedom.todolist.business.todolist.TodolistService
import com.adedom.todolist.business.todolist.TodolistServiceImpl
import io.ktor.locations.*
import org.koin.dsl.module

@KtorExperimentalLocationsAPI
private val businessModule = module {

    single { DefaultBusiness() }

    single<AuthService> { AuthServiceImpl() }

    single<TodolistService> { TodolistServiceImpl(get(), get()) }

}

@KtorExperimentalLocationsAPI
internal val getBusinessModule = businessModule
