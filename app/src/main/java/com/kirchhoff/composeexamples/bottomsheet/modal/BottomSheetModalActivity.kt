package com.kirchhoff.composeexamples.bottomsheet.modal

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kirchhoff.composeexamples.R
import com.kirchhoff.composeexamples.bottomsheet.BottomSheetContent
import com.kirchhoff.composeexamples.bottomsheet.BottomSheetTopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BottomSheetModalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ModalBottomSheetLayoutScreen() }
    }

    @Preview(showBackground = true)
    @Composable
    fun TopBarPreview() {
        ModalBottomSheetLayoutScreen()
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ModalBottomSheetLayoutScreen() {
        val modalBottomSheetState =
            rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
        val scope = rememberCoroutineScope()
        ModalBottomSheetLayout(
            sheetContent = {
                BottomSheetContent()
            },
            sheetState = modalBottomSheetState,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            sheetBackgroundColor = colorResource(id = R.color.black),
            // scrimColor = Color.Red,  // Color for the fade background when you open/close the drawer
        ) {
            Scaffold(
                topBar = { BottomSheetTopBar() },
                backgroundColor = colorResource(id = R.color.teal_700)
            ) {
                ModalBottomSheetMainScreen(scope = scope, state = modalBottomSheetState)
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun ModalBottomSheetLayoutScreenPreview() {
        ModalBottomSheetLayoutScreen()
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun ModalBottomSheetMainScreen(scope: CoroutineScope, state: ModalBottomSheetState) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_500),
                    contentColor = Color.White
                ),
                onClick = {
                    scope.launch {
                        state.show()
                    }
                }) {
                Text(text = "Open Modal Bottom Sheet Layout")
            }
        }
    }
}