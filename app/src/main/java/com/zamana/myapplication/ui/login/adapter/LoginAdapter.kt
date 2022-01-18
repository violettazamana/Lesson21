package com.zamana.myapplication.ui.login.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.databinding.ItemLoginBinding

class LoginAdapter(
    val context: Context,
    val onClick: (login: String) -> Unit
) : RecyclerView.Adapter<LoginViewHolder>() {

    private var list = arrayListOf<UserLogin>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        val binding = ItemLoginBinding.inflate(LayoutInflater.from(context))
        return LoginViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onClick(list[position].userName)
        }
    }

    override fun getItemCount() = list.size

    fun setDataList(data: ArrayList<UserLogin>) {
        list = data
        notifyDataSetChanged()
    }
}