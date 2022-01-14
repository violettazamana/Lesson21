package com.zamana.myapplication.database

data class UniversityEntity(
    val id: Long,
    val fullName: String?,
    val shortName: String,
    val faculty: ArrayList<String>
)