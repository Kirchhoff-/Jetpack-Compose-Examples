package com.kirchhoff.composeexamples.animation

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun ArcRotationView() {
    val infiniteTransition = rememberInfiniteTransition()

    val circleColor = Color(0xFFFF0000)
    val arcColor = Color(0XFF000000)
    
    val firstAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 180f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val secondAngle by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val circleAnimation by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 80f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, delayMillis = 100, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .padding(12.dp)
                .size(100.dp)
        ) {
            drawArc(
                color = arcColor,
                startAngle = firstAngle,
                sweepAngle = 90f,
                useCenter = false,
                style = Stroke(width = 10f, cap = StrokeCap.Round),
            )

            drawArc(
                color = arcColor,
                startAngle = secondAngle,
                sweepAngle = 90f,
                useCenter = false,
                style = Stroke(width = 10f, cap = StrokeCap.Round),
            )

            drawCircle(
                color = arcColor,
                radius = 120f,
            )

            drawCircle(
                color = circleColor,
                radius = circleAnimation,
            )
        }
    }
}
