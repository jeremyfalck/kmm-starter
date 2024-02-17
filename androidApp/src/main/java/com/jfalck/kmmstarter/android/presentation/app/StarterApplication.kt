package com.jfalck.kmmstarter.android.presentation.app

import android.app.Application
import com.jfalck.kmmstarter.android.data.di.androidDataModule
import com.jfalck.kmmstarter.android.presentation.di.androidPresentationModule
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
            modules(appModule + androidPresentationModule + androidDataModule)
        }
    }
}