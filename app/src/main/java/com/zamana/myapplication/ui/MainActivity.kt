package com.zamana.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zamana.myapplication.R
import com.zamana.myapplication.databinding.ActivityMainBinding
import com.zamana.myapplication.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment()).commit()
    }
}