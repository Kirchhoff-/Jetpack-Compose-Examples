package com.kirchhoff.composeexamples.clickablelocalizedtext.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import com.kirchhoff.composeexamples.clickablelocalizedtext.model.StringAnnotation

@Composable
internal fun ClickableLocalizedText(
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    stringsAnnotations: List<StringAnnotation>,
    onClick: (String) -> Unit
) {
    // Build an annotated string from the text and the annotations.
    val annotatedString = buildAnnotatedString {
        append(text)
        stringsAnnotations.forEach { stringAnnotation ->
            val startIndex = text.indexOf(stringAnnotation.tag)
            val endIndex = startIndex + stringAnnotation.tag.length
            addStyle(
                style = stringAnnotation.style,
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = stringAnnotation.tag,
                annotation = stringAnnotation.annotation,
                start = startIndex,
                end = endIndex
            )
        }
    }

    ClickableText(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        text = annotatedString,
        style = textStyle,
        onClick = { position ->
            stringsAnnotations.forEach { annotation ->
                annotatedString
                    .getStringAnnotations(annotation.tag, position, position)
                    .firstOrNull()?.let { stringAnnotation ->
                        onClick.invoke(stringAnnotation.item)
                        return@forEach
                    }
            }
        }
    )
}