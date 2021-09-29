package com.kirchhoff.composeexamples.counterbadge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class CounterBadgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterBadgePreview()
        }
    }
}

@Composable
private fun TextLabelArea(@Suppress("SameParameterValue") text: String) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var count by remember { mutableStateOf(10) }

        Box(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                onTextLayout = { textLayoutResult ->
                    if (textLayoutResult.hasVisualOverflow) {
                        val lineEndIndex = textLayoutResult.getLineEnd(
                            lineIndex = 0,
                            visibleEnd = true
                        )
                        count = text
                            .substring(lineEndIndex)
                            .count { it == ',' }
                    }
                },
            )
        }

        if (count != 0) {
            CounterBadge(count = count)
        }
    }
}

@Composable
private fun CounterBadge(count: Int) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp)
            .size(32.dp)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colors.onBackground.copy(alpha = 0.3f))
    ) {
        Text(
            text = "+$count",
            overflow = TextOverflow.Visible,
            maxLines = 1,
            modifier = Modifier
                .align(Alignment.Center),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterBadgePreview() {
    Card(
        Modifier.padding(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onSurface),
    ) {
        TextLabelArea(
            text = "Text1, Text1, Text1, Text1, Text1, Text1, Text1, Text1, Text1"
        )
    }
}