package com.kirchhoff.composeexamples.animateborders

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kirchhoff.composeexamples.animateborders.ui.AnimateBordersUi

class AnimateBordersActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimateBordersActivityUi()
        }
    }
}

@Preview
@Composable
private fun AnimateBordersActivityUi() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AnimateBordersUi()
    }
}