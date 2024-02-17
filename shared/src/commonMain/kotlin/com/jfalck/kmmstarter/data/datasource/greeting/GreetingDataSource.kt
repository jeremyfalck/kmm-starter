package com.jfalck.kmmstarter.data.datasource.greeting

interface GreetingDataSource {
    suspend fun getGreeting(): String
}