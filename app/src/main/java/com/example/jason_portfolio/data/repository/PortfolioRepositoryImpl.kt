package com.example.jason_portfolio.data.repository
import com.example.jason_portfolio.data.model.DataInfo
import com.example.jason_portfolio.data.remote.ApiService
import com.example.jason_portfolio.data.remote.PortfolioRepository
import io.reactivex.rxjava3.core.Single
 
class PortfolioRepositoryImpl  (private val api: ApiService
) : PortfolioRepository {

    override fun getContact(): Single<DataInfo> {
        return api.getContact()
            .map { response ->
                DataInfo(
                    email = response.email,
                    phone = response.phone,
                    linkedIn = response.linkedIn,
                    gitHub = response.gitHub
                )
            }
    }

}