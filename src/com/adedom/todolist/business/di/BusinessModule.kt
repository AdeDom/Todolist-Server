package com.adedom.todolist.business.di

import com.adedom.todolist.business.auth.AuthService
import com.adedom.todolist.business.auth.AuthServiceImpl
import io.ktor.locations.*
import org.koin.dsl.module

@KtorExperimentalLocationsAPI
private val businessModule = module {

    single<AuthService> { AuthServiceImpl() }

}

@KtorExperimentalLocationsAPI
val getBusinessModule = businessModule
