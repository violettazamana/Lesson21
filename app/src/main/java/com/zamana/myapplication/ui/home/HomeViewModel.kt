package com.zamana.myapplication.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zamana.myapplication.model.University
import com.zamana.myapplication.reposytory.CatRepository
import com.zamana.myapplication.reposytory.UniversityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: UniversityRepository,
    private val catRepository: CatRepository
) : ViewModel() {

    val listData = MutableLiveData<ArrayList<University>>()

    fun getData() {
        listData.value = repository.getListOfUniversity().map {
            University(it.shortName, it.faculty.size)
        } as ArrayList<University>
    }
//
//    fun getCatList() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response = catRepository.getCats()
//            if (response.isSuccessful) {
//                response.body()
//            }
//        }
//    }
}