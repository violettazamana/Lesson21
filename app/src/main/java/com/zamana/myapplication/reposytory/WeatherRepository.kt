package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.WeatherDataBase
import com.zamana.myapplication.model.Weather
import java.util.*
import kotlin.collections.ArrayList

class WeatherRepository {

    fun searchByName(city: String): ArrayList<Weather> {
        return WeatherDataBase.listWeather
            .find { it.city == city }
            ?.listWeather ?: arrayListOf()
    }
}