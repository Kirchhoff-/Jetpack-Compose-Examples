package com.kirchhoff.composeexamples.otptextfield.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OtpTextFieldCharView(
    index: Int,
    text: String
) {
    val isFocused = text.length == index
    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }
    val elementColor = if (isFocused) Color.DarkGray else Color.LightGray

    Text(
        modifier = Modifier
            .width(40.dp)
            .border(1.dp, elementColor, RoundedCornerShape(8.dp))
            .padding(2.dp),
        text = char,
        color = elementColor,
        textAlign = TextAlign.Center
    )
}