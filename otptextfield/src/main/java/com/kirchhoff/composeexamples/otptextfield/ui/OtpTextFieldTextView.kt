package com.kirchhoff.composeexamples.otptextfield.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OtpTextFieldTextView(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    BasicTextField(
        modifier = modifier,
        value = otpText,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
                        Row(horizontalArrangement = Arrangement.Center) {
                            repeat(otpCount) { index ->
                                OtpTextFieldCharView(
                                    index = index,
                                    text = otpText
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
        },
        onValueChange = {
            if (it.length <= otpCount) onOtpTextChange.invoke(it, it.length == otpCount)
        }
    )
}