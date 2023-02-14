package com.example.proyectorestapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url
import www.iesmurgi.u9_proyprofesoressqlite.Product

interface APIService {

    @GET
    suspend fun getProductByCode(@Url url:String): Response<Alimento>

}