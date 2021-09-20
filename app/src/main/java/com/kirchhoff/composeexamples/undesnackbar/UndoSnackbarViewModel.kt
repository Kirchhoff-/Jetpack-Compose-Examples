package com.kirchhoff.composeexamples.undesnackbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UndoSnackbarViewModel: ViewModel() {

    private val list = mutableListOf(
        UndoSnackbarTask(1L, "One", true),
        UndoSnackbarTask(2L, "Two", false),
        UndoSnackbarTask(3L, "Three", false),
        UndoSnackbarTask(4L, "Fourth", true),
        UndoSnackbarTask(5L, "Five", false),
        UndoSnackbarTask(6L, "Six", false),
        UndoSnackbarTask(7L, "Seven", true),
        UndoSnackbarTask(8L, "Eight", false),
        UndoSnackbarTask(9L, "Nine", false)
    )

    private val _taskList: MutableStateFlow<List<UndoSnackbarTask>> = MutableStateFlow(list)
    val taskList: StateFlow<List<UndoSnackbarTask>>
        get() = _taskList.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())

    fun onCheckedChange(task: UndoSnackbarTask) {
        val current = _taskList.value
        val replacement = current.map { if (it.id == task.id) it.copy(isCompleted = !it.isCompleted) else it }
        _taskList.value = replacement
    }
}