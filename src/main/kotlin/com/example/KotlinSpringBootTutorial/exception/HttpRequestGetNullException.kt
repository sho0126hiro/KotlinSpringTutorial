package com.example.KotlinSpringBootTutorial.exception

import java.lang.RuntimeException

class HttpRequestGetNullException: RuntimeException {
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(message: String) : super(message)
    constructor(cause: Throwable) : super(cause)
    constructor() : super()
}