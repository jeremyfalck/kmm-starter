package com.jfalck.kmmstarter.di.module

import com.jfalck.kmmstarter.data.datasource.greeting.local.GreetingLocalDataSource
import com.jfalck.kmmstarter.data.datasource.greeting.remote.GreetingRemoteDataSource
import com.jfalck.kmmstarter.domain.usecase.GetGreetingUseCase
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.factoryOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val httpModule = module {
    single { HttpClient() }
}

val greetingModule = module {
    factoryOf(::GetGreetingUseCase)
    factoryOf(::GreetingRemoteDataSource)
    factoryOf(::GreetingLocalDataSource)
}

val coroutineModule = module {
    factory<CoroutineScope>(){ CoroutineScope(Dispatchers.IO) }
}

val commonModules = httpModule + greetingModule + coroutineModule