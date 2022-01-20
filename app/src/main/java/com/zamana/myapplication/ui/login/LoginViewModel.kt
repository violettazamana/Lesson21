package com.zamana.myapplication.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zamana.myapplication.database.login.InfoUser
import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.reposytory.PhoneRepository
import com.zamana.myapplication.reposytory.UserLoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: UserLoginRepository,
    private val phoneRepository: PhoneRepository
) : ViewModel() {

    lateinit var onSaveUser: () -> Unit
    lateinit var showPhone: (phone: String) -> Unit
    lateinit var showProgressBar: (isShow: Boolean) -> Unit

    val list = MutableLiveData<ArrayList<UserLogin>>()

    fun saveUser(login: String, password: String) {
        viewModelScope.launch {
            showProgressBar(true)
            repository.saveUser(UserLogin(0, login, password))
            phoneRepository.saveUser(InfoUser(0, "+1212233", login))
            onSaveUser()
            loadList()
            showProgressBar(false)
        }
    }

    suspend fun loadList() {
        showProgressBar(true)
        list.postValue(repository.getList() as ArrayList)
        showProgressBar(false)
    }

    suspend fun getPhone(login: String) {
        showPhone(phoneRepository.getList(login).phoneNumber)
    }
}