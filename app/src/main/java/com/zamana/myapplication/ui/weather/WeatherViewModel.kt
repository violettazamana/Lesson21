package com.zamana.myapplication.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zamana.myapplication.model.Weather
import com.zamana.myapplication.reposytory.WeatherRepository

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    val list = MutableLiveData<ArrayList<Weather>>()

    fun getListWeather(city: String) {
        list.value = repository.searchByName(city)
    }

    fun removeItem(item: Weather) {
        val newList = list.value ?: arrayListOf()
        newList.remove(item)
        list.value = newList
    }
}