package com.example.jason_portfolio.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.math.sin

@Composable
fun AnimatedWaveBackground() {

    val infiniteTransition = rememberInfiniteTransition()

    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (3 * Math.PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 5000,
                easing = LinearEasing
            )
        )
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val width = size.width
        val height = size.height

        drawRect(
            color = Color(0xFF6F866F)
        )

        for (x in 0..width.toInt()) {

            val y =
                (height * 0.9f) +
                        50f * sin(
                    ((x.toFloat() / width) * 2f * Math.PI + phase)
                ).toFloat()

            drawCircle(
                color = Color(0xFF00BFFF),
                radius = 2f,
                center = Offset(x.toFloat(), y)
            )
        }
    }
}