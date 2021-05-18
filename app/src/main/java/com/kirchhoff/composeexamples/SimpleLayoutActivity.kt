package com.kirchhoff.composeexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SimpleLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NewStory() }
    }

    @Composable
    fun NewStory() {
        Column(
                modifier = Modifier.padding(16.dp)
        ) {
            Image(
                    painter = painterResource(R.drawable.image_simple_layout),
                    contentDescription = null,
                    modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
            )
            Spacer(Modifier.preferredHeight(16.dp))

            Text(
                    "First text field",
                    style = typography.h6
            )
            Text(
                    "Second text field",
                    style = typography.body2
            )
            Text(
                    "Third text field",
                    style = typography.body2
            )
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {

    }
}