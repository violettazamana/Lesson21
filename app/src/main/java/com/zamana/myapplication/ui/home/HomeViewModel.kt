package com.zamana.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zamana.myapplication.model.University
import com.zamana.myapplication.reposytory.UniversityRepository

class HomeViewModel(
    private val repository: UniversityRepository
) : ViewModel() {

    val listData = MutableLiveData<ArrayList<University>>()

    fun getData() {
        listData.value = repository.getListOfUniversity()
    }
}