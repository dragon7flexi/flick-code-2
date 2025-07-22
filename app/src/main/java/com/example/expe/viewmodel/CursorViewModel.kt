package com.example.expe.viewmodel

import Cursor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CursorViewModel: ViewModel() {
    var cursor by mutableStateOf(Cursor(0, 0))
        private set

    fun update(newRow: Int, newCol: Int) {
        cursor = cursor.copy(row = newRow, col = newCol)
    }

    fun reset() {
        cursor = cursor.copy(row = 0, col = 0)
    }
}
