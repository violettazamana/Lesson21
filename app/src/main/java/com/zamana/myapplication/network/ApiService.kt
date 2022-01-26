package com.zamana.myapplication.network

import com.zamana.myapplication.model.CatsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("images/search")
    suspend fun getList(): Response<ArrayList<CatsItem>>

    @GET("images/search")
    suspend fun searchByBreed(
        @Query("breed_id") breed: String
    ): Response<ArrayList<CatsItem>>

}