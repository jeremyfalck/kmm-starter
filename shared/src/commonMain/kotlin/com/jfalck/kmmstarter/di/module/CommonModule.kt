package com.jfalck.kmmstarter.di.module

import com.jfalck.kmmstarter.domain.usecase.GetGreetingUseCase
import com.jfalck.kmmstarter.data.datasource.greeting.local.GreetingLocalDataSource
import com.jfalck.kmmstarter.data.datasource.greeting.remote.GreetingRemoteDataSource
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val httpModule = module {
    single { HttpClient() }
}

val greetingModule = module {
    factoryOf(::GetGreetingUseCase)
    factoryOf(::GreetingRemoteDataSource)
    factoryOf(::GreetingLocalDataSource)
}

val commonModules = httpModule + greetingModule