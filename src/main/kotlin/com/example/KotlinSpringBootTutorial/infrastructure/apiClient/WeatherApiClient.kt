package com.example.KotlinSpringBootTutorial.infrastructure.apiClient

import com.example.KotlinSpringBootTutorial.exception.HttpRequestGetNullException
import com.example.KotlinSpringBootTutorial.infrastructure.entity.WeatherEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class WeatherApiClient {
    private val restTemplate: RestTemplate = RestTemplate()
    private val endPoint: String = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040"
    fun weatherRequest(): WeatherEntity {
        var response = restTemplate.getForObject(this.endPoint, WeatherEntity::class.java)
//        throw HttpRequestGetNullException("weatherAPI2")
        if (response != null) {
            return response
        } else {
            throw HttpRequestGetNullException("weatherAPI")
        }
    }
}