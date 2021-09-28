package com.kirchhoff.composeexamples.clock

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.util.*

class ClockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClockPreview()
        }
    }
}

@Composable
fun Number(
    value: Int,
    active: Boolean,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        if (active) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.background(backgroundColor),
    ) {
        Text(
            text = value.toString(),
            fontSize = 20.sp,
            color = Color.White,
        )
    }
}

@Composable
fun NumberColumn(
    range: IntRange,
    current: Int,
    modifier: Modifier = Modifier,
) {
    val size = 40.dp
    val mid = (range.last - range.first) / 2f
    val reset = current == range.first
    val offset by animateDpAsState(
        targetValue = size * (mid - current),
        animationSpec = if (reset) {
            spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessLow,
            )
        } else {
            tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing,
            )
        }
    )

    Column(
        modifier
            .offset(y = offset)
            .clip(RoundedCornerShape(percent = 25))
    ) {
        range.forEach { num ->
            Number(num, num == current, Modifier.size(size))
        }
    }
}

@Composable
fun Clock(time: ClockTime) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val padding = Modifier.padding(horizontal = 4.dp)

        NumberColumn(0..2, time.hours / 10, padding)
        NumberColumn(0..9, time.hours % 10, padding)
        Spacer(Modifier.size(16.dp))
        NumberColumn(0..5, time.minutes / 10, padding)
        NumberColumn(0..9, time.minutes % 10, padding)
        Spacer(Modifier.size(16.dp))
        NumberColumn(0..5, time.seconds / 10, padding)
        NumberColumn(0..9, time.seconds % 10, padding)
    }
}

@Composable
@Preview
fun NumberPreview() {
    Column {
        Number(value = 3, active = true)
        Number(value = 7, active = false)
    }
}

@Composable
@Preview
fun NumberColumnPreview() {
    NumberColumn(range = 0..9, current = 5)
}

@Composable
@Preview
fun ClockPreview() {
    var time by remember { mutableStateOf(currentTime()) }
    LaunchedEffect(0) { // 3
        while (true) {
            time = currentTime()
            delay(1000)
        }
    }

    Clock(time)
}

private fun currentTime(): ClockTime {
    val cal = Calendar.getInstance()
    return ClockTime(
        hours = cal.get(Calendar.HOUR_OF_DAY),
        minutes = cal.get(Calendar.MINUTE),
        seconds = cal.get(Calendar.SECOND)
    )
}