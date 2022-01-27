package com.zamana.myapplication.reposytory

import com.zamana.myapplication.model.CatsItem
import com.zamana.myapplication.network.NetworkManager
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class CatRepository(private val manager: NetworkManager) {

    fun getCats(): Single<Response<ArrayList<CatsItem>>> =
        manager.provideUnauthorizedCachedRequestsApi().getList()
            .subscribeOn(Schedulers.io())

    suspend fun searchCats() =
        manager.provideUnauthorizedCachedRequestsApi().searchByBreed("beng")

}