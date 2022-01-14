package com.zamana.myapplication.ui.weather.adapter

import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.databinding.ItemWeatherBinding
import com.zamana.myapplication.model.Weather

class WeatherViewHolder(
    val binding: ItemWeatherBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Weather) {
        binding.temperatureTextView.text = "${item.temperature}°C"
    }
}