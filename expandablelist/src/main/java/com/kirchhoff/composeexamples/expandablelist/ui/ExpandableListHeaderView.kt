package com.kirchhoff.composeexamples.expandablelist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderView(title: String, onItemClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .clickable { onItemClick.invoke() }
            .padding(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 17.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderViewPreview() {
    HeaderView("Title 0") {}
}
