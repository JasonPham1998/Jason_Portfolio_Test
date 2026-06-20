package com.example.jason_portfolio.domain.usecase


import com.example.jason_portfolio.data.model.DataInfo
import com.example.jason_portfolio.data.repository.PortfolioRepositoryImpl
import io.reactivex.rxjava3.core.Single

class GetDataInfoUseCase(
    private val repository: PortfolioRepositoryImpl
) {
    operator fun invoke(): Single<DataInfo> {
        return repository.getContact()
    }
}
