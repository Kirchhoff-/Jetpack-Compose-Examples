package com.kirchhoff.composeexamples.otptextfield

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kirchhoff.composeexamples.otptextfield.ui.OtpTextFieldTextView

class OtpTextFieldActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OtpTextFieldUi()
        }
    }
}

@Preview
@Composable
private fun OtpTextFieldUi() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        color = Color.White
    ) {
        var otpValue by remember {
            mutableStateOf("")
        }

        OtpTextFieldTextView(
            otpText = otpValue,
            onOtpTextChange = { value, _ ->
                otpValue = value
            }
        )
    }
}