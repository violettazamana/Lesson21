package com.zamana.myapplication.database.login

import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    fun insertUser(user: UserLogin)

    @Query("select * from UserLogin")
    fun getAllList(): List<UserLogin>

    @Query("select * from UserLogin where :userName = user_name")
    fun getZlataListPassword(userName: String): List<UserLogin>

    @Update
    fun updateUser(user: UserLogin)

    @Delete
    fun delete(user: UserLogin)
}