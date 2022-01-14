package com.zamana.myapplication.database

import com.zamana.myapplication.model.Weather
import com.zamana.myapplication.model.WeatherForCity

object WeatherDataBase {

    val listCity = arrayListOf("Minsk", "Grodno")

    val listWeather = arrayListOf(
        WeatherForCity("Minsk", arrayListOf(Weather(20, true),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false),
            Weather(18, false))),
        WeatherForCity("Grodno", arrayListOf(Weather(22, true),
            Weather(21, true))))
}