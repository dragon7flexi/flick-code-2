package com.example.expe.viewmodel

import Cursor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expe.data.CursorRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CursorViewModel(
    private val repository: CursorRepository
) : ViewModel() {

    var cursor by mutableStateOf(Cursor(0, 0))
        private set

    init {
        viewModelScope.launch {
            cursor = repository.cursorFlow.first()
        }
    }

    fun update(newRow: Int, newCol: Int) {
        val newCursor = cursor.copy(row = newRow, col = newCol)
        cursor = newCursor

        viewModelScope.launch {
            repository.saveCursor(newCursor)
        }
    }

    fun reset() {
        val newCursor = Cursor(0, 0)
        cursor = newCursor

        viewModelScope.launch {
            repository.saveCursor(newCursor)
        }
    }
}