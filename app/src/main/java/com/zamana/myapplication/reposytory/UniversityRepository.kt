package com.zamana.myapplication.reposytory

import com.zamana.myapplication.database.UniversityDataBase
import com.zamana.myapplication.database.UniversityEntity

class UniversityRepository {

    fun getListOfUniversity(): ArrayList<UniversityEntity> = UniversityDataBase.listUniversity
}