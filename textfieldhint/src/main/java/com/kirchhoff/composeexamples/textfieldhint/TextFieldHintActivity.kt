package com.kirchhoff.composeexamples.textfieldhint

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.composeexamples.textfieldhint.ui.TextFieldHintUI

class TextFieldHintActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldHintUI()
        }
    }
}
