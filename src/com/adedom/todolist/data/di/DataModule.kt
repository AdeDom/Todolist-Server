package com.adedom.todolist.data.di

import com.adedom.todolist.data.mapper.Mapper
import com.adedom.todolist.data.repository.DefaultRepository
import com.adedom.todolist.data.repository.DefaultRepositoryImpl
import io.ktor.locations.*
import io.ktor.util.*
import org.koin.dsl.module

@InternalAPI
@KtorExperimentalLocationsAPI
private val dataModule = module {

    single { Mapper() }

    single<DefaultRepository> { DefaultRepositoryImpl(get()) }

}

@InternalAPI
@KtorExperimentalLocationsAPI
internal val getDataModule = dataModule
