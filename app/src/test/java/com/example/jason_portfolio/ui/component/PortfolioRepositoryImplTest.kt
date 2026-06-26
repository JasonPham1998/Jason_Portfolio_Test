package com.example.jason_portfolio.ui.component

import com.example.jason_portfolio.data.model.DataInfo
import com.example.jason_portfolio.data.remote.ApiService
import com.example.jason_portfolio.data.repository.PortfolioRepositoryImpl
import io.reactivex.rxjava3.core.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class PortfolioRepositoryImplTest {

    private lateinit var apiService: ApiService
    private lateinit var repository: PortfolioRepositoryImpl

    @Before
    fun setup() {
        apiService = Mockito.mock(ApiService::class.java)
        repository = PortfolioRepositoryImpl(apiService)
    }

    @Test
    fun `getContact should return mapped DataInfo`() {


        val mockResponse = DataInfo(
            email = "test@gmail.com",
            phone = "123456789",
            linkedIn = "linkedin.com/test",
            gitHub = "github.com/test"
        )

        Mockito.`when`(apiService.getContact())
            .thenReturn(Single.just(mockResponse))


        val result = repository.getContact().blockingGet()


        Assert.assertEquals("test@gmail.com", result.email)
        Assert.assertEquals("123456789", result.phone)
        Assert.assertEquals("linkedin.com/test", result.linkedIn)
        Assert.assertEquals("github.com/test", result.gitHub)

        Mockito.verify(apiService).getContact()
    }

    @Test
    fun getContact_should_emit_error() {
        val exception = RuntimeException("Network Error")
        Mockito.`when`(apiService.getContact())
            .thenReturn(
                Single.error(exception)
            )
        val testObserver =
            repository.getContact().test()
        testObserver
            .assertError(RuntimeException::class.java)}
}