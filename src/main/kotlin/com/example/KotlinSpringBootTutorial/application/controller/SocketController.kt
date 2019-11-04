package com.example.KotlinSpringBootTutorial.application.controller

import com.example.KotlinSpringBootTutorial.application.resource.SocketSuccessBody
import com.example.KotlinSpringBootTutorial.domain.service.SocketService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/socket")
class SocketController {
    @GetMapping("/")
    fun test(): SocketSuccessBody {
//        val socketService: SocketService = SocketService()
//        socketService.test()
        return SocketSuccessBody("success","OK")
    }
}