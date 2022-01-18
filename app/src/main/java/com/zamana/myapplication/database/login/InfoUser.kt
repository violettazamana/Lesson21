package com.zamana.myapplication.database.login

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class InfoUser(
    @PrimaryKey(autoGenerate = true)
    val key: Long,
    val phoneNumber: String,
    val userLogin: String
)