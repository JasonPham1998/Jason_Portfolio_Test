package com.example.jason_portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jason_portfolio.presentation.MainViewModel


import com.example.jason_portfolio.ui.theme.MainScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel=viewModel()
            val State = viewModel.uiState.collectAsStateWithLifecycle().value

            LaunchedEffect(Unit) {
                viewModel.loadContact()
            }
            MainScreen(
                uiState = State,
                onContactClick = viewModel::onContactClick)
            }
        }
}



