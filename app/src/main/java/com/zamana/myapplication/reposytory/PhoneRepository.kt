package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.login.InfoUser
import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.database.login.UserLoginDataBase

class PhoneRepository {

    private val phoneDao = UserLoginDataBase.dataBase.infoDao()

    fun saveUser(phone: InfoUser) {
        phoneDao.insertPhone(phone)
    }

    fun getList(login: String) = phoneDao.getPhone(login)
}