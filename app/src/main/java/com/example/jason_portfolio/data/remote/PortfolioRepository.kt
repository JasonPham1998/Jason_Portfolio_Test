package com.example.jason_portfolio.data.remote

import com.example.jason_portfolio.data.model.DataInfo
import io.reactivex.rxjava3.core.Single

interface PortfolioRepository {
    fun getContact(): Single<DataInfo>
}