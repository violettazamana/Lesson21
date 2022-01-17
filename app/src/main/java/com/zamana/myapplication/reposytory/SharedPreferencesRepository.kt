package com.zamana.myapplication.reposytory

import android.content.Context
import androidx.core.content.edit

private const val FILE_NAME = "shared_pref_file"
private const val USER_NAME = "user_name"
private const val CITY_LIST = "list_city"

private val CITY_DEFAULT_LIST = setOf("Minsk", "Grodno")

class SharedPreferencesRepository(
    private val context: Context
) {

    private val preferenses = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun saveUserName(userName: String) {
        preferenses.edit {
            putString(USER_NAME, userName)
        }
    }

    fun getUserName(): String = preferenses.getString(USER_NAME, "") ?: ""

    fun setCityList(cityList: Set<String>) {
        preferenses.edit {
            putStringSet(CITY_LIST, cityList)
        }
    }

    fun getCity(): Set<String>? = preferenses.getStringSet(CITY_LIST, CITY_DEFAULT_LIST)
}