package com.kirchhoff.composeexamples.boxwithconstraints.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxWithConstraintsCard(
    title: String,
    subtitle: String,
    height: Dp,
    width: Dp
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(height)
            .width(width)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Black)
                .padding(24.dp)
        ) {
            Text(
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                color = Color.White,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxWithConstraintsCardPreview(
    title: String = "Title 1",
    subtitle: String = "Subtitle 1",
    height: Dp = 80.dp,
    width: Dp = 60.dp
) {
    BoxWithConstraintsCard(
        title = title,
        subtitle = subtitle,
        height = height,
        width = width
    )
}