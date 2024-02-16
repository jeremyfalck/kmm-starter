package com.jfalck.kmmstarter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform