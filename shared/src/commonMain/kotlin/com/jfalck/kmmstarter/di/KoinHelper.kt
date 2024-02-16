package com.jfalck.kmmstarter.di

import com.jfalck.kmmstarter.di.module.appModule
import org.koin.core.context.startKoin

class KoinHelper {

    fun initKoin() {
        startKoin {
            modules(appModule())
        }
    }

}