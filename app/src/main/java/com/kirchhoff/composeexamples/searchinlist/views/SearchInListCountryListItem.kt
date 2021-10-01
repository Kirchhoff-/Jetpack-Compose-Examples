package com.kirchhoff.composeexamples.searchinlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kirchhoff.composeexamples.R

@Composable
fun SearchInListCountryListItem(countryText: String) {
    Row(
        modifier = Modifier
            .background(colorResource(id = R.color.purple_500))
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))
    ) {
        Text(text = countryText, fontSize = 18.sp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun SearchInListCountryListItemPreview() {
    SearchInListCountryListItem(countryText = "United States 🇺🇸")
}