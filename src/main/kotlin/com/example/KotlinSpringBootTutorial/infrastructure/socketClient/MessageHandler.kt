package com.example.KotlinSpringBootTutorial.infrastructure.socketClient

import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.lang.Exception

class MessageHandler : TextWebSocketHandler() {
    private var users: ArrayList<WebSocketSession> = ArrayList<WebSocketSession>()
    // 接続の確立
    override fun afterConnectionEstablished(session: WebSocketSession) {
        users.add(session)
        try {
            users.forEach {it.sendMessage(TextMessage("hello!"))}
        } catch (e: Exception) {
            session.sendMessage(TextMessage("Sorry!"))
            session.close()
        }
    }

}