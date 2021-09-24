package com.kirchhoff.composeexamples.viewmodel

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class BaseViewModelExampleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseViewModelExampleDemo()
        }
    }
}

@Composable
fun BaseViewModelExampleDemo(model: BaseViewModelExampleViewModel = viewModel()) {
    val count by model.counterLiveDate.observeAsState(0)
    Demo("This is $count") { model.increaseCounter() }
}

@Composable
fun Demo(text: String, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        BasicText(text)
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = onClick,
        ) {
            BasicText(text = "Add 1")
        }
    }
}

@Preview
@Composable
fun PreviewDemo() {
    Demo("Preview")
}