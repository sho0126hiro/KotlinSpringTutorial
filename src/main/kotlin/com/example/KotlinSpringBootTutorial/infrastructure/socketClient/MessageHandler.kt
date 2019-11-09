package com.example.KotlinSpringBootTutorial.infrastructure.socketClient

import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.lang.Exception
import org.springframework.web.socket.CloseStatus

class MessageHandler : TextWebSocketHandler() {
    private var users: ArrayList<WebSocketSession> = ArrayList<WebSocketSession>()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        // 接続したら呼ばれる
        users.add(session)
        try {
            users.forEach {it.sendMessage(TextMessage("hello!"))}
        } catch (e: Exception) {
            session.sendMessage(TextMessage("Sorry!"))
            session.close()
        }
    }
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        // WebSocketクライアントからメッセージを受信した時に呼ばれる.
        try {
            users.forEach {it.sendMessage(message)}
        } catch (e: Exception) {
            session.sendMessage(TextMessage("sendMessage: Error"))
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        // 接続が切られたら呼ばれる.
        var rem = users
                .filter { user -> user.id == session.id }
                .first()
        users.remove(rem)
        var targets = users.filter { user -> user.id != session.id }
        targets.forEach {it.sendMessage(TextMessage("Good Bye."))}
    }
}