package com.jfalck.kmmstarter.domain.usecase

import com.jfalck.kmmstarter.domain.repository.GreetingRepository

class GetGreetingUseCase(private val greetingRepository: GreetingRepository) {

    suspend operator fun invoke(): String =
        greetingRepository.getGreeting()

}