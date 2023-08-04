package com.kirchhoff.composeexamples.touchfeedback

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kirchhoff.composeexamples.touchfeedback.ui.bouncingClickable

class TouchFeedbackAnimationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TouchFeedbackAnimationUi()
        }
    }
}

@Preview
@Composable
private fun TouchFeedbackAnimationUi() {
    Box(
        modifier = Modifier
            .bouncingClickable { print("Clicked...") }
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Black)
    )
}