package com.kirchhoff.composeexamples.undesnackbar


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun HomeList(undoViewModel: UndoSnackbarViewModel = viewModel()) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val onShowSnackbar: (UndoSnackbarTask) -> Unit = { task ->
        coroutineScope.launch {
            val snackbarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = "${task.title} completed",
                actionLabel = "Undo"
            )

            when(snackbarResult) {
                SnackbarResult.Dismissed -> Log.d("TAG", "Snackbar dismissed")
                SnackbarResult.ActionPerformed -> undoViewModel.onCheckedChange(task)
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeTopBar() }
    ) {
        val list by remember(undoViewModel) { undoViewModel.taskList }.collectAsState()

        LazyColumn {
            items(
                items = list,
                key = { it.id },
                itemContent = { task ->
                    ListItem(
                        task = task,
                        onCheckedChange = { task ->
                            undoViewModel.onCheckedChange(task)
                            onShowSnackbar(task)
                        }
                    )
                }
            )
        }
    }
}

@Composable
private fun ListItem(task: UndoSnackbarTask, onCheckedChange: (UndoSnackbarTask) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = task.isCompleted, onCheckedChange = { onCheckedChange(task) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(
           text = task.title,
           style = MaterialTheme.typography.body1,
           overflow = TextOverflow.Ellipsis,
           maxLines = 1
        )
    }
}

@Composable
private fun HomeTopBar() {
    TopAppBar {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.h5,
                text = "My tasks"
            )
        }
    }
}