package com.kirchhoff.composeexamples.expandablelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirchhoff.composeexamples.expandablelist.model.ExpandableListData
import com.kirchhoff.composeexamples.expandablelist.repository.ExpandableListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExpandableListViewModel: ViewModel() {

    private val itemsList = MutableStateFlow(listOf<ExpandableListData>())
    val items: StateFlow<List<ExpandableListData>> get() = itemsList

    private val itemIdsList = MutableStateFlow(listOf<Int>())
    val itemIds: StateFlow<List<Int>> get() = itemIdsList

    private val repository = ExpandableListRepository()

    init {
        getData()
    }

    fun onItemClicked(itemId: Int) {
        itemIdsList.value = itemIdsList.value.toMutableList().apply {
            if (this.contains(itemId)) {
                this.remove(itemId)
            } else {
                this.add(itemId)
            }
        }
    }

    private fun getData() {
        viewModelScope.launch {
            itemsList.emit(repository.items())
        }
    }
}
