package com.example.KotlinSpringBootTutorial.infrastructure.socketClient

import org.springframework.stereotype.Component
import java.io.*
import java.net.Socket

@Component
class ConnectToClient (
        private val socket: Socket,
        private val id: Int
){
    private lateinit var inputStream: InputStream
    private lateinit var bufferedReader:BufferedReader
    private lateinit var printWriter: PrintWriter
    fun run() {
        // 受信処理
        try {
            inputStream = socket.getInputStream()
            bufferedReader = BufferedReader(InputStreamReader(inputStream))
            printWriter =  PrintWriter(BufferedWriter(OutputStreamWriter(socket.getOutputStream())))
        } catch (e: Exception){
            e.printStackTrace()
        }
        try {
            while (inputStream.available() == 0) {}

            val received = bufferedReader.readLine()
            println("received data is $received")
            // 送信処理
            printWriter.println("[From Server] Received data is {$received}")
            printWriter.flush()
        } catch (e: Exception) {
            e.printStackTrace()
            try {
                this.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        println("Bye $id")
    }
    private fun close() {
        bufferedReader.close()
        printWriter.close()
        inputStream.close()
        socket.close()
    }
}