package com.adedom.todolist.data.di

import com.adedom.todolist.data.mapper.Mapper
import com.adedom.todolist.data.repository.DefaultRepository
import com.adedom.todolist.data.repository.DefaultRepositoryImpl
import org.koin.dsl.module

private val dataModule = module {

    single { Mapper() }

    single<DefaultRepository> { DefaultRepositoryImpl(get()) }

}

internal val getDataModule = dataModule
