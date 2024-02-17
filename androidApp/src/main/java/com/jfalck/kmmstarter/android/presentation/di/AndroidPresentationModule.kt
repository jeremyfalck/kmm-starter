package com.jfalck.kmmstarter.android.presentation.di

import com.jfalck.kmmstarter.android.presentation.GreetingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val androidPresentationModule = module {
    viewModelOf(::GreetingViewModel)
}