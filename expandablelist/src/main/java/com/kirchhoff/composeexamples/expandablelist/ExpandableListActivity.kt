package com.kirchhoff.composeexamples.expandablelist

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.kirchhoff.composeexamples.expandablelist.ui.ContainerView

class ExpandableListActivity: AppCompatActivity() {

    private val viewModel by viewModels<ExpandableListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpandableListUi(viewModel)
        }
    }
}

@Composable
fun ExpandableListUi(viewModel: ExpandableListViewModel) {
    val itemIds by viewModel.itemIds.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(viewModel.items.value) { index, item ->
                ContainerView(
                    item = item,
                    expanded = itemIds.contains(index),
                    onItemClick = { viewModel.onItemClicked(index) }
                )
            }
        }
    }
}
