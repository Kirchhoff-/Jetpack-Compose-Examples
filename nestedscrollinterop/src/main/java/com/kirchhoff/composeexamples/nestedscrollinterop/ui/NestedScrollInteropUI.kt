package com.kirchhoff.composeexamples.nestedscrollinterop.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@ExperimentalComposeUiApi
@Composable
fun NestedScrollInteropUI(items: List<Int>) {
    val toolbarHeightPx = with(LocalDensity.current) { 48.dp.roundToPx().toFloat() }
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    // Compose Scrollable
    Column(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {
        TopAppBar(
            modifier = Modifier
                .height(48.dp)
                .offset {
                    IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt())
                },
            title = { Text("toolbar offset is ${toolbarOffsetHeightPx.value}") }
        )
        LazyColumnItems(items = items)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun LazyColumnItems(items: List<Int>) {
    LazyColumn(
        modifier = Modifier
            .nestedScroll(rememberNestedScrollInteropConnection())
    ) {
        itemsIndexed(items) { index, _ ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = items[index].toString()
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
private fun NestedScrollInteropUIPreview() {
    NestedScrollInteropUI(items = (0..100).toList())
}
