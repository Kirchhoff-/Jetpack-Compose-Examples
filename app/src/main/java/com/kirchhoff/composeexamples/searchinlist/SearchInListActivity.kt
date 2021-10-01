package com.kirchhoff.composeexamples.searchinlist

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import com.kirchhoff.composeexamples.R
import com.kirchhoff.composeexamples.searchinlist.views.SearchInListCountryList

class SearchInListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = SearchInListCountryRepository()
        setContent {
            Scaffold(
                backgroundColor = colorResource(id = R.color.purple_200)
            ) {
                SearchInListMainScreen(repository = repository)
            }
        }
    }
}

@Composable
fun SearchInListMainScreen(repository: SearchInListCountryRepository) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        SearchInListSearchView(textState)
        SearchInListCountryList(repository = repository, state = textState)
    }
}