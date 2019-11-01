package com.example.KotlinSpringBootTutorial.domain.service

import com.example.KotlinSpringBootTutorial.infrastructure.apiClient.WeatherApiClient
import com.example.KotlinSpringBootTutorial.infrastructure.entity.WeatherEntity
import org.springframework.stereotype.Service

@Service
class WeatherService {
    private val weatherApiClient: WeatherApiClient = WeatherApiClient()
    fun getWeatherInfo(): WeatherEntity {
        return weatherApiClient.weatherRequest()
    }
}