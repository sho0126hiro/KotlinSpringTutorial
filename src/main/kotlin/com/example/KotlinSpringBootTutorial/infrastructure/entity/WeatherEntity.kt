package com.example.KotlinSpringBootTutorial.infrastructure.entity

class WeatherEntity (
        val title: String,
        val description: Description
){
    class Description(val text: String)
}