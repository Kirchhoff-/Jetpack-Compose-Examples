package com.kirchhoff.composeexamples.clickablelocalizedtext.model

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.SpanStyle

@Immutable
internal data class StringAnnotation(
    val tag: String,
    val annotation: String,
    val style: SpanStyle
)
