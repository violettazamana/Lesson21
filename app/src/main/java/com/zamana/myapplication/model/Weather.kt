package com.zamana.myapplication.model

data class Weather(
    val temperature: Int,
    val isWind: Boolean,
    val dateAndTime: Long? = null
)

data class WeatherForCity(
    val city: String,
    val listWeather: ArrayList<Weather>
)