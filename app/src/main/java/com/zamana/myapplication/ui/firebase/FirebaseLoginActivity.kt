package com.zamana.myapplication.ui.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zamana.myapplication.databinding.ActivityLoginFirebaseBinding

class FirebaseLoginActivity : AppCompatActivity() {

    private lateinit var viewModel: FirebaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginFirebaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, FirebaseViewModelFactory())
            .get(FirebaseViewModel::class.java).apply {
                toast = {
                    Toast.makeText(
                        this@FirebaseLoginActivity,
                        if (it) {
                            "LOGGED IN"
                        } else {
                            "ERROR"
                        }, Toast.LENGTH_LONG
                    ).show()
                }
            }
        binding.loginButton.setOnClickListener {
            viewModel.login(
                binding.loginText.text.toString(), binding.passwordText.text.toString()
            )
        }
    }
}