package com.example.KotlinSpringBootTutorial.infrastructure.socketClient

import org.springframework.stereotype.Component
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket

@Component
class TestSocketClient {
    fun test(): Unit{
        val serverSocket = ServerSocket()
        // register a socket
        serverSocket.reuseAddress = true
        serverSocket.bind(InetSocketAddress(SocketConfig.Connection.Test.PORT_NUMBER))
        println("connect")
        // connecting process
        try {
            val socket: Socket = serverSocket.accept()
            println("start")
            val connectToClient: ConnectToClient = ConnectToClient(socket,80)
            connectToClient.run()
        } catch (e: Exception) {
            println("Error(Started)")
            println(e.toString())
        }
    }
}