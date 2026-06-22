package com.example.jason_portfolio.presentation

data class MainUiState(


    val email: String = "",
    val phone: String = "",
    val linkedIn: String = "",
    val gitHub: String = "",

    val selectedContact: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)