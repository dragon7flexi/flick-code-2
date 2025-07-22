package com.example.expe.usecase.cursor

import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.CursorViewModel

class CursorNavigator(
    private val cursorViewModel: CursorViewModel,
    private val codeViewModel: CodeViewModel,
) {
    private val cursor get() = cursorViewModel.cursor
    private val code get() = codeViewModel.code

    fun up() {
        if (cursor.isAtFirstLine()) return
        val newCol = calcColOnUp(cursor, code)
        cursorViewModel.update(cursor.row - 1, newCol)
    }

    fun down() {
        if (cursor.isAtLastLine(code)) return
        val newCol = calcColOnDown(cursor, code)
        cursorViewModel.update(cursor.row + 1, newCol)
    }

    fun left() {
        if (cursor.isAtLineStart()) return
        cursorViewModel.update(cursor.row, cursor.col - 1)
    }

    fun right() {
        if (cursor.isAtLineEnd(code[cursor.row])) return
        cursorViewModel.update(cursor.row, cursor.col + 1)
    }

    fun toLineStart() {
        cursorViewModel.update(cursor.row, 0)
    }

    fun toLineEnd() {
        val strLen = code[cursor.row].length
        cursorViewModel.update(cursor.row, strLen)
    }

    fun moveBefore(char: Char) {
        val idx = code[cursor.row].indexOf(char, startIndex = cursor.col + 1)
        if (idx == -1) return // Not found
        cursorViewModel.update(cursor.row, idx)
    }

    fun moveAfter(char: Char) {
        val idx = code[cursor.row].indexOf(char, startIndex = cursor.col + 1)
        if (idx == -1) return // Not found
        cursorViewModel.update(cursor.row, idx + 1)
    }
}