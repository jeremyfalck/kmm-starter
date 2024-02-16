package com.jfalck.kmmstarter.android

import android.app.Application
import com.jfalck.kmmstarter.android.di.androidModule
import com.jfalck.kmmstarter.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StarterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StarterApplication)
            androidLogger()
            modules(appModule + androidModule)
        }
    }
}