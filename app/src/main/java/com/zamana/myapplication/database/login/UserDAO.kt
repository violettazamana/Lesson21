package com.zamana.myapplication.database.login

import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user: UserLogin)

    @Query("select * from UserLogin")
    suspend fun getAllList(): List<UserLogin>

    @Query("select * from UserLogin where :userName = user_name")
    suspend fun getZlataListPassword(userName: String): List<UserLogin>

    @Update
    suspend fun updateUser(user: UserLogin)

    @Delete
    suspend fun delete(user: UserLogin)
}