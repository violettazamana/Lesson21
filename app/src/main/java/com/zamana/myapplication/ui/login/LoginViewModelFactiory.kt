package com.zamana.myapplication.ui.login

import com.zamana.myapplication.network.NetworkManager
import com.zamana.myapplication.reposytory.CatRepository
import com.zamana.myapplication.reposytory.PhoneRepository
import com.zamana.myapplication.reposytory.UserLoginRepository
import com.zamana.myapplication.ui.base.BaseViewModelFactory

class LoginViewModelFactiory : BaseViewModelFactory<LoginViewModel>(LoginViewModel::class.java) {

    override fun createViewModel(): LoginViewModel {
        return LoginViewModel(
            UserLoginRepository(),
            PhoneRepository(),
            CatRepository(NetworkManager())
        )
    }

}