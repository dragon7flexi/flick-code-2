package com.example.expe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StdinViewModel : ViewModel() {
    var text by mutableStateOf("")
        private set

    fun update(newText: String) {
        text = newText
    }

    fun reset() {
        text = ""
    }

}