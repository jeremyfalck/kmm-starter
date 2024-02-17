package com.jfalck.kmmstarter.android.data

import com.jfalck.kmmstarter.Platform
import com.jfalck.kmmstarter.data.datasource.greeting.local.GreetingLocalDataSource
import com.jfalck.kmmstarter.data.datasource.greeting.remote.GreetingRemoteDataSource
import com.jfalck.kmmstarter.domain.repository.GreetingRepository

class GreetingRepositoryImpl(
    private val greetingRemoteDataSource: GreetingRemoteDataSource,
    private val greetingLocalDataSource: GreetingLocalDataSource,
    private val platform: Platform
) : GreetingRepository {
    override suspend fun getGreeting(): String {
        val localGreeting = greetingLocalDataSource.getGreeting()
        return if (localGreeting.isEmpty()) {
            val remoteGreeting = greetingRemoteDataSource.getGreeting()
            greetingLocalDataSource.saveGreeting(remoteGreeting)
            formatGreeting(remoteGreeting)
        } else {
            formatGreeting(localGreeting)
        }
    }

    private fun formatGreeting(greeting: String) =
        greeting + "\n${platform.name}"
}