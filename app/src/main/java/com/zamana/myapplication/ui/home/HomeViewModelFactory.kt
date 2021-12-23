package com.zamana.myapplication.ui.home

import com.zamana.myapplication.reposytory.UniversityRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class HomeViewModelFactory : BaseViewModelFactory<HomeViewModel>(HomeViewModel::class.java) {

    override fun createViewModel(): HomeViewModel {
        return HomeViewModel(UniversityRepository())
    }

}