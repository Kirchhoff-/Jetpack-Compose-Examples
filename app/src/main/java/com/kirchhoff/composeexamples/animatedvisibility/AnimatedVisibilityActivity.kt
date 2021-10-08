package com.kirchhoff.composeexamples.animatedvisibility

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kirchhoff.composeexamples.R

class AnimatedVisibilityActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedVisibilityUi()
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
private fun AnimatedVisibilityUi() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.background
    ) {
        var imageVisible by remember { mutableStateOf(false) }

        val imageAlpha: Float by animateFloatAsState(
            targetValue = if (imageVisible) 1f else 0f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = LinearEasing
            )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_simple_layout),
                contentDescription = "Some content description",
                alpha = imageAlpha,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Button(onClick = { imageVisible = !imageVisible }) {
                Text("Click Me")
            }
        }
    }
}