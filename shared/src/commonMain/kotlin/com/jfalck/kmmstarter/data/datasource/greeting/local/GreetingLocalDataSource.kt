package com.jfalck.kmmstarter.data.datasource.greeting.local

import co.touchlab.kermit.Logger
import com.jfalck.kmmstarter.data.datasource.greeting.GreetingDataSource

//To simplify setup, using memory cache as a local repository.
// The best would be using a DB -> Implementation should go in platform related modules
class GreetingLocalDataSource : GreetingDataSource {

    companion object {
        private const val TAG = "GreetingLocalDataSource"
    }

    private var greeting: String = ""
    override suspend fun getGreeting(): String =
        greeting

    fun saveGreeting(newGreeting: String) {
        Logger.d(TAG) { "Saving greeting : $newGreeting" }
        greeting = newGreeting
    }
}