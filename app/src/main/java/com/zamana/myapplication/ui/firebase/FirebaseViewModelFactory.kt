package com.zamana.myapplication.ui.firebase

import com.zamana.myapplication.reposytory.FirebaseRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class FirebaseViewModelFactory :
    BaseViewModelFactory<FirebaseViewModel>(FirebaseViewModel::class.java) {

    override fun createViewModel(): FirebaseViewModel {
        return FirebaseViewModel(FirebaseRepository())
    }

}