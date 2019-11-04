package com.example.KotlinSpringBootTutorial.domain.service

import com.example.KotlinSpringBootTutorial.infrastructure.socketClient.TestSocketClient
import org.springframework.stereotype.Service

@Service
class SocketService {
    private val webSocketClient: TestSocketClient = TestSocketClient()
    fun test(): Unit{
        return
    }
}