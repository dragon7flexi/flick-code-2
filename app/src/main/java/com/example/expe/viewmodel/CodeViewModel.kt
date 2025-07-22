package com.example.expe.viewmodel

import com.example.expe.data.CodeRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expe.model.Token
import com.example.expe.usecase.code.syntaxhighlight.Tokenizer
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CodeViewModel(private val repository: CodeRepository) : ViewModel() {
    var code by mutableStateOf(listOf(""))
        private set

    var tokens by mutableStateOf<List<List<Token>>>(listOf(listOf()))
        private set

    private val tokenizer = Tokenizer()
    private var saveJob: Job? = null

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            val loadedCode = repository.loadCode()
            code = loadedCode.ifEmpty { listOf("") }
            tokens = code.map { tokenizer.tokenizeLine(it) }
        }
    }

    fun deleteAll() {
        code = listOf("")
        tokens = listOf(listOf())
        scheduleSave()
    }

    fun deleteLine(row: Int) {
        if (row !in code.indices) return

        code = code.toMutableList().apply { removeAt(row) }
        tokens = tokens.toMutableList().apply { removeAt(row) }
        scheduleSave()
    }

    fun replaceLines(startRow: Int, newLines: List<String>) {
        code = code.toMutableList().apply {
            removeAt(startRow)
            addAll(startRow, newLines)
        }

        tokens = tokens.toMutableList().apply {
            removeAt(startRow)
            addAll(startRow, newLines.map { tokenizer.tokenizeLine(it) })
        }

        scheduleSave()
    }

    fun updateAll(newCode: List<String>) {
        code = newCode
        tokens = newCode.map { tokenizer.tokenizeLine(it) }
        scheduleSave()
    }

    fun updateLine(row: Int, newLine: String) {
        if (row !in code.indices) return

        code = code.toMutableList().apply {
            this[row] = newLine
        }

        tokens = tokens.toMutableList().apply {
            this[row] = tokenizer.tokenizeLine(newLine)
        }

        scheduleSave()
    }

    private fun scheduleSave() {
        saveJob?.cancel()
        saveJob = viewModelScope.launch {
            delay(500) // debounce 500ms
            repository.saveCode(code)
        }
    }
}
