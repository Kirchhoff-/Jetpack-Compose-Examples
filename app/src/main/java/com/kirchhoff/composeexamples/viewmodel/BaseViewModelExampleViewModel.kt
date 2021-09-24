package com.kirchhoff.composeexamples.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModelExampleViewModel: ViewModel() {

    val counterLiveDate: LiveData<Int>
        get() = counter

    private val counter = MutableLiveData<Int>()
    private var count = 0

    fun increaseCounter() {
        counter.value = ++count
    }
}