package com.zamana.myapplication.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zamana.myapplication.database.login.InfoUser
import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.reposytory.PhoneRepository
import com.zamana.myapplication.reposytory.UserLoginRepository

class LoginViewModel(
    private val repository: UserLoginRepository,
    private val phoneRepository: PhoneRepository
) : ViewModel() {

    lateinit var onSaveUser: () -> Unit
    lateinit var showPhone: (phone: String) -> Unit
    lateinit var showProgressBar: (isShow: Boolean) -> Unit

    val list = MutableLiveData<ArrayList<UserLogin>>()

    fun saveUser(login: String, password: String) {
        showProgressBar(true)
        repository.saveUser(UserLogin(0, login, password))
        phoneRepository.saveUser(InfoUser(0, "+1212233", login))
        onSaveUser()
        loadList()
        showProgressBar(false)
    }

    fun loadList() {
        showProgressBar(true)
        list.value = repository.getList() as ArrayList
        showProgressBar(false)
    }

    fun getPhone(login: String) {
        showPhone(phoneRepository.getList(login).phoneNumber)
    }
}