package com.zamana.myapplication.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.zamana.myapplication.databinding.ItemUniversityBinding
import com.zamana.myapplication.model.University

class UniversityViewHolder(
    private val binding: ItemUniversityBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(university: University) {
        binding.univeristyTitle.text = university.name
    }
}