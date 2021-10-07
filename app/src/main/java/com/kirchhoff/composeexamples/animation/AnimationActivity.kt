package com.kirchhoff.composeexamples.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AnimationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AnimationUI() }
    }
}

@Composable
@Preview
fun AnimationUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       CircleTwinView()
       Spacer(modifier = Modifier.height(16.dp))
       CircleOffsetView()
       Spacer(modifier = Modifier.height(16.dp))
       ArcRotationView()
    }
}
