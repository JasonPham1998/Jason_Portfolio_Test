package com.example.jason_portfolio.data

import retrofit2.http.GET

interface ApiService {

    @GET("api/contact")
    suspend fun getContact(): DataInfo
}