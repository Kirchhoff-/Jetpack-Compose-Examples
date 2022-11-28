package com.kirchhoff.composeexamples.expandablelist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kirchhoff.composeexamples.expandablelist.model.ExpandableListData

@Composable
fun ContainerView(
    item: ExpandableListData,
    expanded: Boolean,
    onItemClick: () -> Unit
) {
    Box(
      modifier = Modifier
          .background(Color.DarkGray)
    ) {
        Column {
            HeaderView(item.title, onItemClick)
            ExpandableView(item.description, expanded)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContainerViewPreview() {
    ContainerView(
        item = ExpandableListData("Title 0", "Description 0"),
        expanded = true,
        onItemClick = {}
    )
}
