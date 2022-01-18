package com.zamana.myapplication.database.login

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class UserLogin(
    @PrimaryKey(autoGenerate = true)
    val key: Long,
    @ColumnInfo(name = "user_name")
    val userName: String,
    @ColumnInfo(name = "password")
    val password: String
)