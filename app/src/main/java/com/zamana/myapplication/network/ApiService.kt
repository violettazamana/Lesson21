package com.zamana.myapplication.network

import com.zamana.myapplication.model.CatsItem
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("images/search")
    fun getList(): Single<Response<ArrayList<CatsItem>>>

    @GET("images/search")
    suspend fun searchByBreed(
        @Query("breed_id") breed: String
    ): Response<ArrayList<CatsItem>>

}