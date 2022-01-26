package com.zamana.myapplication.reposytory

import com.zamana.myapplication.network.NetworkManager

class CatRepository(private val manager: NetworkManager) {

    suspend fun getCats() =
        manager.provideUnauthorizedCachedRequestsApi().getList()

    suspend fun searchCats() =
        manager.provideUnauthorizedCachedRequestsApi().searchByBreed("beng")

}