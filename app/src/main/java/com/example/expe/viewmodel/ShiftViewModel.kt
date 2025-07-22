package com.example.expe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShiftViewModel: ViewModel() {
    var isShifted by mutableStateOf(false)
        private set

    fun toggle() {
        isShifted = !isShifted
    }

    fun reset() {
        isShifted = false
    }
}