package com.zamana.myapplication.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.databinding.ItemUniversityBinding
import com.zamana.myapplication.model.University

class UniversityAdapter(
    val context: Context
) : RecyclerView.Adapter<UniversityViewHolder>() {

    private var list = arrayListOf<University>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding = ItemUniversityBinding.inflate(LayoutInflater.from(context))
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setDataList(data: ArrayList<University>) {
        list = data
        notifyDataSetChanged()
    }
}