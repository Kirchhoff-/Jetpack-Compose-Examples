package com.kirchhoff.composeexamples.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleOffsetView() {
    val infiniteTransition = rememberInfiniteTransition()

    val easing = LinearOutSlowInEasing

    val firstColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF3f8765),
        targetValue = Color(0xFFBA3f876),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val secondColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF546732),
        targetValue = Color(0xFF987654),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val offsetX by animateValues(
        values = listOf(0f, 100f, -100f, 0f),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = easing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by animateValues(
        values = listOf(1f, 10f, 10f, 10f, 1f),
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = easing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(100.dp)
        ) {
            drawCircle(
                color = Color.White
            )

            drawCircle(
                color = secondColor,
                radius = 80f + scale * 4f,
                center = Offset(-offsetX + this.center.x, this.center.y)
            )

            drawCircle(
                color = firstColor,
                radius = 80f + scale * 4f,
                center = Offset(offsetX + this.center.x, this.center.y)
            )
        }
    }
}
