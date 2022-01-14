package com.zamana.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zamana.myapplication.R
import com.zamana.myapplication.databinding.ActivityMainBinding
import com.zamana.myapplication.ui.home.HomeFragment
import com.zamana.myapplication.ui.weather.WeatherFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var lastOpenItem = R.id.home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        AddDialog().show(supportFragmentManager, "")
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    lastOpenItem = R.id.home
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment()).commit()
                }
                R.id.settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment()).commit()
                }
                R.id.weather -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, WeatherFragment()).commit()
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        binding.bottomNavigation.selectedItemId = lastOpenItem
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_home, menu)
//        return true
//    }
}