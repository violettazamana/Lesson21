package com.zamana.myapplication.model

data class CatsItem(
    val breeds: List<Any>,
    val height: Int,
    val id: String,
    val url: String,
    val width: Int,
    var name: String? = null
)