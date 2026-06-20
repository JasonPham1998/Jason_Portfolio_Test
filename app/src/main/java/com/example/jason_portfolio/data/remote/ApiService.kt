package com.example.jason_portfolio.data.remote

import com.example.jason_portfolio.data.model.DataInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {

    @GET("api/contact")
    fun getContact(): Single<DataInfo>
}