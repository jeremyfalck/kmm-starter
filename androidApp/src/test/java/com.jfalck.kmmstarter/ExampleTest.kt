package com.jfalck.kmmstarter

import com.jfalck.kmmstarter.android.data.GreetingRepositoryImpl
import com.jfalck.kmmstarter.data.datasource.greeting.local.GreetingLocalDataSource
import com.jfalck.kmmstarter.data.datasource.greeting.remote.GreetingRemoteDataSource
import com.jfalck.kmmstarter.domain.repository.GreetingRepository
import io.kotest.core.spec.style.FunSpec
import io.mockk.coEvery
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class GreetingRepositoryTest : FunSpec({

    lateinit var greetingRepository: GreetingRepository
    lateinit var greetingRemoteDataSource: GreetingRemoteDataSource

    val greetingLocalDataSource = spyk<GreetingLocalDataSource>()

    val platform = Platform()

    beforeTest {
        greetingRemoteDataSource = mockk<GreetingRemoteDataSource>()
        greetingRepository = GreetingRepositoryImpl(greetingRemoteDataSource, greetingLocalDataSource, platform)
    }

    test("saving greeting locally when fetching remote") {
        val expected = "greeting"
        coEvery { greetingRemoteDataSource.getGreeting() } returns expected
        val actual: String = greetingRepository.getGreeting()
        verify(exactly = 1) { greetingLocalDataSource.saveGreeting(expected) }
        Assertions.assertEquals(expected + "\n${platform.name}", actual)
    }

})
