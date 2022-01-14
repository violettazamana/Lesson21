package com.zamana.myapplication.ui.weather

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.databinding.FragmentWeatherBinding
import com.zamana.myapplication.model.Weather
import com.zamana.myapplication.ui.weather.adapter.WeatherAdapter

class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding

    lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, WeatherViewModelFactory())
            .get(WeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner) {
            setList(it)
        }
        binding.grodno.setOnClickListener {
            viewModel.getListWeather("Grodno")
        }
        binding.minsk.setOnClickListener {
            viewModel.getListWeather("Minsk")
        }
    }

    private fun setList(list: ArrayList<Weather>) {
        binding.weatherList.run {
            if (adapter == null) {
                adapter = WeatherAdapter(requireContext()) {
                    viewModel.removeItem(it)
//                    Toast.makeText(requireContext(), "${it.temperature}", Toast.LENGTH_LONG).show()
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as WeatherAdapter).setList(list)
        }
    }
}