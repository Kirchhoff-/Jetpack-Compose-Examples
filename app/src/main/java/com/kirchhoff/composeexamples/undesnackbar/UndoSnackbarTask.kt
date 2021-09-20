package com.kirchhoff.composeexamples.undesnackbar

data class UndoSnackbarTask(
    val id: Long,
    val title: String,
    var isCompleted: Boolean
)
