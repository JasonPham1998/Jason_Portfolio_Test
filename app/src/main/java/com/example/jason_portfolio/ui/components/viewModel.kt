package com.example.jason_portfolio.ui.components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jason_portfolio.data.DataInfo
import com.example.jason_portfolio.data.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<DataInfo?>(null)
    val uiState: StateFlow<DataInfo?> = _uiState

    init {
        loadContact()
        Log.d("VIEWMODEL", "ViewModel created")

    }

    private fun loadContact() {
        viewModelScope.launch {
            try {

                val result = RetrofitClient.api.getContact()
                _uiState.value = result
                Log.d("API_TEST", "Calling API...")
                Log.d("API_TEST", "Result = $result")

            } catch (e: Exception) {

                Log.e("API_ERROR", "Failed to load contact", e)
            }
        }
    }
}