package com.zamana.myapplication.database.login

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface InfoUserDao {

    @Insert
    suspend fun insertPhone(phone: InfoUser)

    @Query("select * from InfoUser where :login = userLogin")
    suspend fun getPhone(login: String): InfoUser
}