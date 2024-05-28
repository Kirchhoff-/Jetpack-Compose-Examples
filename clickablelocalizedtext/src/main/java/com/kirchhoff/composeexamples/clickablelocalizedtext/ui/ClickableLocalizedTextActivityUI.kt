package com.kirchhoff.composeexamples.clickablelocalizedtext.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import com.kirchhoff.composeexamples.clickablelocalizedtext.R
import com.kirchhoff.composeexamples.clickablelocalizedtext.model.StringAnnotation

@Composable
internal fun ClickableLocalizedTextActivityUI() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val annotations = listOf(
            StringAnnotation(
                tag = stringResource(id = R.string.terms),
                annotation = "https://firstUrl.com",
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontStyle = MaterialTheme.typography.body1.fontStyle,
                    textDecoration = TextDecoration.Underline,
                )
            ),
            StringAnnotation(
                tag = stringResource(id = R.string.privacy_policy),
                annotation = "https://secondUrl.com",
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontStyle = MaterialTheme.typography.body1.fontStyle,
                    textDecoration = TextDecoration.Underline,
                )
            )
        )

        ClickableLocalizedText(
            text = stringResource(id = R.string.agreement_text),
            stringsAnnotations = annotations,
            onClick = { url -> Log.e("TAG123", "Click") }
        )
    }
}
