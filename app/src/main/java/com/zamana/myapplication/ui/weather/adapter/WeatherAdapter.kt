package com.zamana.myapplication.ui.weather.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.databinding.ItemWeatherBinding
import com.zamana.myapplication.model.Weather

class WeatherAdapter(
    val context: Context,
    val onItemClick: (item: Weather) -> Unit
) : RecyclerView.Adapter<WeatherViewHolder>() {

    private var list = arrayListOf<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        return WeatherViewHolder(ItemWeatherBinding.inflate(LayoutInflater.from(context)))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick(list[position])
        }
    }

    override fun getItemCount() = list.size

    fun setList(dataList: ArrayList<Weather>) {
        list = dataList
        notifyDataSetChanged()
    }
}