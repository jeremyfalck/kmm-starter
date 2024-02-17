package com.jfalck.kmmstarter.domain.repository

interface GreetingRepository {
    suspend fun getGreeting(): String
}