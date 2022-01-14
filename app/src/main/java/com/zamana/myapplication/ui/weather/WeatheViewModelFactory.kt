package com.zamana.myapplication.ui.weather

import com.zamana.myapplication.reposytory.WeatherRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class WeatherViewModelFactory :
    BaseViewModelFactory<WeatherViewModel>(WeatherViewModel::class.java) {

    override fun createViewModel(): WeatherViewModel {
        return WeatherViewModel(WeatherRepository())
    }

}