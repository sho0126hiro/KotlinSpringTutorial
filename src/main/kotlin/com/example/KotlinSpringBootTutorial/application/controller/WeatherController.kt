package com.example.KotlinSpringBootTutorial.application.controller

import com.example.KotlinSpringBootTutorial.exception.HttpRequestGetNullException
import com.example.KotlinSpringBootTutorial.application.resource.WeatherBody
import com.example.KotlinSpringBootTutorial.domain.service.WeatherService
import com.example.KotlinSpringBootTutorial.infrastructure.entity.WeatherEntity
import org.springframework.http.HttpStatus
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/weather")
class WeatherController(){

    @RequestMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @RequestMapping("/hello2")
    fun hello2(): WeatherBody {
        return WeatherBody("hello","world")
    }

    @RequestMapping("/test")
    fun getWeather(): WeatherBody {
        val weatherService: WeatherService = WeatherService()
        val weatherInfo: WeatherEntity = weatherService.getWeatherInfo()
        return WeatherBody(
                weatherInfo.title,weatherInfo.description.text
        )
    }
}