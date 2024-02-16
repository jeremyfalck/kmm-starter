package com.jfalck.kmmstarter.di.module

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.jfalck.kmmstarter.Platform

val platformModule = module {
    singleOf(::Platform)
}