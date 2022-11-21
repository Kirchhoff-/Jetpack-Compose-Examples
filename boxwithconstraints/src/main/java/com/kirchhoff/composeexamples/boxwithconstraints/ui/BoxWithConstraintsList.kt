package com.kirchhoff.composeexamples.boxwithconstraints.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import com.kirchhoff.composeexamples.boxwithconstraints.model.BoxWithConstraintsData

@Composable
fun BoxWithConstraintsScope.AdaptiveLayoutCardList(cardsList: List<BoxWithConstraintsData>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(24.dp)
    ) {
        items(cardsList) { card ->
            val isLandscapeMode = maxWidth > maxHeight

            val cardWidth = if (isLandscapeMode) maxWidth / 4 else maxWidth / 2
            val resultHeight = if (isLandscapeMode) maxHeight / 3 else maxHeight / 4
            val resultWidth = if (isLandscapeMode) cardWidth * 0.85f else cardWidth * 0.8f

            BoxWithConstraintsCard(
                title = card.title,
                subtitle = card.subtitle,
                height = resultHeight,
                width = resultWidth
            )
        }
    }
}