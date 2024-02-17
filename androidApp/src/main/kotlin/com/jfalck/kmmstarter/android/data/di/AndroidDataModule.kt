package com.jfalck.kmmstarter.android.data.di

import com.jfalck.kmmstarter.android.data.GreetingRepositoryImpl
import com.jfalck.kmmstarter.domain.repository.GreetingRepository
import org.koin.dsl.module

val androidDataModule = module {
    factory<GreetingRepository> { GreetingRepositoryImpl(get(), get(), get()) }
}