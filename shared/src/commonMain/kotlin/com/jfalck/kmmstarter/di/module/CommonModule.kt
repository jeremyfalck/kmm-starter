package com.jfalck.kmmstarter.di.module

import com.jfalck.kmmstarter.Greeting
import com.jfalck.kmmstarter.domain.usecase.GreetingUseCase
import io.ktor.client.HttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val commonModule = module {
    single { HttpClient() }
    singleOf(::Greeting)

    factoryOf(::GreetingUseCase)
}