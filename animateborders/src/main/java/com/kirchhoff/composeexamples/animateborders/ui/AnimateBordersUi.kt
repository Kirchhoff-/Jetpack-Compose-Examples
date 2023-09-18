package com.kirchhoff.composeexamples.animateborders.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AnimateBordersUi() {
    Column(modifier = Modifier.fillMaxSize()) {
        AnimateBordersCardWithAnimatedBorder(
            borderColors = listOf(Color.Yellow, Color.Cyan, Color.Red, Color.Green)
        ) {
            Text(text = "Test text")
        }
    }
}
