package com.zamana.myapplication.ui.login.adapter

import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.databinding.ItemLoginBinding

class LoginViewHolder(
    private val binding: ItemLoginBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserLogin) {
        binding.login.text = user.userName
        binding.pass.text = user.password
    }
}