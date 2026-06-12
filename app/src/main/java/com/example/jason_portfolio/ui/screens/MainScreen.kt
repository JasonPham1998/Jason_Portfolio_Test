package com.example.jason_portfolio.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jason_portfolio.ui.components.AnimatedWaveBackground
import com.example.jason_portfolio.ui.components.ProfileHeader

@Composable
fun MainScreen() {

    Box(modifier = Modifier.fillMaxSize()) {

        // 🌊 1. BACKGROUND (always behind everything)
        AnimatedWaveBackground()

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally ) {

            Spacer(modifier = Modifier.height(20.dp))

            ProfileHeader()




        }
    }
}

