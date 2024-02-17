package com.jfalck.kmmstarter.android.data

import com.jfalck.kmmstarter.Greeting
import com.jfalck.kmmstarter.domain.repository.GreetingRepository

class GreetingRepositoryImpl(private val greeting: Greeting) : GreetingRepository {
    override suspend fun getGreeting(): String =
        greeting.greet()
}