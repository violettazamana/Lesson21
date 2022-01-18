package com.zamana.myapplication.database.login

import android.content.Context
import androidx.room.Room

object UserLoginDataBase {

    lateinit var dataBase: AppDatabase

    fun initDataBase(context: Context) {
        if (!this::dataBase.isInitialized) {
            dataBase = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}