package com.jfalck.kmmstarter.data.datasource.greeting.remote

import com.jfalck.kmmstarter.data.datasource.greeting.GreetingDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class GreetingRemoteDataSource(private val httpClient: HttpClient) : GreetingDataSource {

    companion object {
        private const val GREETING_ENDPOINT = "https://ktor.io/docs/"
    }

    override suspend fun getGreeting(): String =
        try {
            httpClient.get(GREETING_ENDPOINT).bodyAsText()
        } catch (e: Exception) {
            ""
        }
}