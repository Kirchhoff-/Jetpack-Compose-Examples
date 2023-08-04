package com.kirchhoff.composeexamples.circularreveal

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kirchhoff.composeexamples.circularreveal.ui.CircularRevealAnimationUi

class CircularRevealAnimationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularRevealAnimationActivityUi()
        }
    }
}

@Preview
@Composable
private fun CircularRevealAnimationActivityUi() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CircularRevealAnimationUi()
    }
}
