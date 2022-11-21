package com.kirchhoff.composeexamples.boxwithconstraints

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kirchhoff.composeexamples.boxwithconstraints.model.BoxWithConstraintsData
import com.kirchhoff.composeexamples.boxwithconstraints.ui.AdaptiveLayoutCardList

class BoxWithConstraintsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxWithConstraintsUi()
        }
    }
}

@Preview
@Composable
private fun BoxWithConstraintsUi() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val cardsData = remember { createCards() }

        BoxWithConstraints {
            AdaptiveLayoutCardList(cardsList = cardsData)
        }
    }
}

private fun createCards(): List<BoxWithConstraintsData> = MutableList(20) { index ->
    val cardNumber = index + 1
    BoxWithConstraintsData(
        title = "Title $cardNumber",
        subtitle = "Subtitle $cardNumber"
    )
}
