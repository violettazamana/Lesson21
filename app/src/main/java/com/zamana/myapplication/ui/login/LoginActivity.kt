package com.zamana.myapplication.ui.login

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zamana.myapplication.R
import com.zamana.myapplication.database.login.UserLoginDataBase
import com.zamana.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UserLoginDataBase.initDataBase(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment()).commit()
    }
}