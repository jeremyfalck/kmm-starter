package com.jfalck.kmmstarter.domain.usecase

import com.jfalck.kmmstarter.domain.repository.GreetingRepository

class GreetingUseCase(private val greetingRepository: GreetingRepository) {

    suspend operator fun invoke(): String =
        greetingRepository.getGreeting()

}