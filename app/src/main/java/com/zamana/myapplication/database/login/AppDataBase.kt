package com.zamana.myapplication.database.login

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserLogin::class, InfoUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDAO

    abstract fun infoDao(): InfoUserDao
}
