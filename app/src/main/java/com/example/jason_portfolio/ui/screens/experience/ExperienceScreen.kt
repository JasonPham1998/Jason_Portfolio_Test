package com.example.jason_portfolio.ui.screens.experience

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ExperienceScreen() {
    val gradientColors= listOf(Black,Red,Yellow)
    Box(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = "Nothing ",
            style = TextStyle(brush=Brush.linearGradient( colors=gradientColors)),
            color = Black,
            fontSize = 25.sp,
            modifier = Modifier.padding(horizontal = 30.dp)

        )
    }

}



