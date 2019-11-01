package com.example.KotlinSpringBootTutorial.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(HttpRequestGetNullException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleHttpRequestGetNullException(e: HttpRequestGetNullException): Map<String, String?> {
        return mapOf(   "type" to "HttpRequestGetNullException",
                        "message" to e.message,
                        "description" to "Null returned by Http request in server")
    }
}