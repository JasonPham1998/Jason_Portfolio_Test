package com.example.jason_portfolio.ui.test

import com.example.jason_portfolio.data.model.DataInfo
import com.example.jason_portfolio.data.repository.PortfolioRepositoryImpl
import com.example.jason_portfolio.domain.usecase.GetDataInfoUseCase
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.junit.Assert.*
import org.mockito.Mockito

class GetDataInfoUseCaseTest {

    private lateinit var repository: PortfolioRepositoryImpl
    private lateinit var useCase: GetDataInfoUseCase

    @Before
    fun setup() {
        repository = mock(PortfolioRepositoryImpl::class.java)
        useCase = GetDataInfoUseCase(repository)
    }

    @Test
    fun `invoke should return contact data from repository`() {

        // Given
        val expectedData = DataInfo(
            email = "test@gmail.com",
            phone = "123456789",
            linkedIn = "linkedin/test",
            gitHub = "github/test"
        )

        `when`(repository.getContact())
            .thenReturn(Single.just(expectedData))

        // When
        val result = useCase().blockingGet()

        // Then
        assertEquals(expectedData, result)

        verify(repository).getContact()
    }
    @Test
    fun invoke_should_return_error_when_repository_fails() {
        val exception = RuntimeException("Network Error")
        Mockito.`when`(repository.getContact())
            .thenReturn(
                Single.error(exception)
            )
        val testObserver = useCase().test()
        testObserver
            .assertError(RuntimeException::class.java)}
    }
