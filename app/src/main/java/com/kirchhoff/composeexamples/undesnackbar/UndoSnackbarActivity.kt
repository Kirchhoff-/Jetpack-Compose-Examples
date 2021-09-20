package com.kirchhoff.composeexamples.undesnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface

class UndoSnackbarActivity: ComponentActivity() {

    private val undoSnackbarViewModel by viewModels<UndoSnackbarViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                HomeList(undoSnackbarViewModel)
            }
        }
    }
}