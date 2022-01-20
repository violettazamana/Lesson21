package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.login.UserLogin
import com.zamana.myapplication.database.login.UserLoginDataBase

class UserLoginRepository {

    private val userDao = UserLoginDataBase.dataBase.userDao()

    suspend fun saveUser(user: UserLogin) {
        userDao.insertUser(user)
    }

    suspend fun getList() = userDao.getZlataListPassword("zlata")
}