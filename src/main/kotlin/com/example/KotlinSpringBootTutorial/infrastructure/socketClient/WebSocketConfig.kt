package com.example.KotlinSpringBootTutorial.infrastructure.socketClient

import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig: WebSocketConfigurer {
    // endpoint
    @CrossOrigin
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(messageHandler(),"/").setAllowedOrigins("*")
    }
    @CrossOrigin
    fun messageHandler(): WebSocketHandler {
        return MessageHandler()
    }
}