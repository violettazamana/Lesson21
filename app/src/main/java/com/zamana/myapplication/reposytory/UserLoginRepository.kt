package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.database.login.UserLoginDataBase

class UserLoginRepository {

    private val userDao = UserLoginDataBase.dataBase.userDao()

    fun saveUser(user: UserLogin) {
        userDao.insertUser(user)
    }

    fun getList() = userDao.getZlataListPassword("zlata")
}