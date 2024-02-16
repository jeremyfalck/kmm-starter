package com.jfalck.kmmstarter

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting(private val platform: Platform, private val httpClient: HttpClient) {
    suspend fun greet(): String {
        val response = httpClient.get("https://ktor.io/docs/")
        return response.bodyAsText() + "\n ${platform.name}"
        //return "Hello, ${platform.name}!"
    }
}