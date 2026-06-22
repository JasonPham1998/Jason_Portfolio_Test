package com.example.jason_portfolio.presentation


import io.reactivex.rxjava3.disposables.CompositeDisposable
import androidx.lifecycle.ViewModel
import com.example.jason_portfolio.data.remote.RetrofitClient
import com.example.jason_portfolio.data.repository.PortfolioRepositoryImpl
import com.example.jason_portfolio.domain.usecase.GetDataInfoUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _uiState = MutableStateFlow(MainUiState())

    val uiState: StateFlow<MainUiState> = _uiState


    private val api = RetrofitClient.api
    private val repository =
        PortfolioRepositoryImpl(api)
    private val useCase = GetDataInfoUseCase(repository)
    fun loadContact() {
        val disposable = useCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

            .doOnSubscribe {
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    error = null
                )
            }

            .subscribe({ result ->

                _uiState.update {
                    it.copy(
                        email = result.email,
                        phone = result.phone,
                        linkedIn = result.linkedIn,
                        gitHub = result.gitHub,
                        isLoading = false,
                        error = null,
                        selectedContact = null)}


            }, { error ->

                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = error.message
                )
            })

        compositeDisposable.add(disposable)
    }
    fun onContactClick(type: String) {
        _uiState.update {
            it.copy(selectedContact = type)
        }
    }


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}