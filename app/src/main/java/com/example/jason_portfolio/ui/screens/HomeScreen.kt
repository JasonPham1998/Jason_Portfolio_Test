package com.example.jason_portfolio.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun HomeScreen() {
    val gradientColors= listOf(Black,Red,Yellow)
    Box(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
            Text(
                text = "Passionate mobile developer focused on Android, " +
                        "Kotlin, and modern software solutions.",
                style = TextStyle(brush=Brush.linearGradient( colors=gradientColors)),
                color = Color.Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 30.dp)

            )
        }

}



