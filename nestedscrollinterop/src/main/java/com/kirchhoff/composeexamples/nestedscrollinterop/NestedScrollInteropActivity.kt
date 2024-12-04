package com.kirchhoff.composeexamples.nestedscrollinterop

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.ExperimentalComposeUiApi
import com.kirchhoff.composeexamples.nestedscrollinterop.ui.NestedScrollInteropUI

class NestedScrollInteropActivity : AppCompatActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedScrollInteropUI(items = (0..100).toList())
        }
    }
}
