package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.UniversityDataBase
import com.zamana.myapplication.database.UniversityEntity
import com.zamana.myapplication.model.University

class UniversityRepository {

    fun getListOfUniversity(): ArrayList<University> =
        UniversityDataBase.listUniversity.filter { !it.fullName.isNullOrEmpty() }.map {
            University(it.shortName, it.faculty.size)
        } as ArrayList<University>
}