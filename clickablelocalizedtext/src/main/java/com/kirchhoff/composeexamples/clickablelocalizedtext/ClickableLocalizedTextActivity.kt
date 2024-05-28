package com.kirchhoff.composeexamples.clickablelocalizedtext

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.composeexamples.clickablelocalizedtext.ui.ClickableLocalizedTextActivityUI

class ClickableLocalizedTextActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickableLocalizedTextActivityUI()
        }
    }
}