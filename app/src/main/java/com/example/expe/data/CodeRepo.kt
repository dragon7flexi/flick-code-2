package com.example.expe.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class CodeRepository(private val context: Context) {
    private val fileName = "code.txt"

    suspend fun saveCode(code: List<String>) {
        withContext(Dispatchers.IO) {
            val text = code.joinToString("\n")
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                it.write(text.toByteArray())
            }
        }
    }

    suspend fun loadCode(): List<String> {
        return withContext(Dispatchers.IO) {
            val file = File(context.filesDir, fileName)
            if (!file.exists()) return@withContext listOf("print(1)", "print(2)")
            context.openFileInput(fileName).bufferedReader().readLines()
        }
    }
}
