package com.example.expe.usecase.code

import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.usecase.cursor.isAtFirstLine
import com.example.expe.usecase.cursor.isAtLineStart
import com.example.expe.viewmodel.CursorViewModel
import com.example.expe.viewmodel.ShiftViewModel
import insertAt
import removeAt

class CodeEditor(
    private val codeViewModel: CodeViewModel,
    private val cursorViewModel: CursorViewModel,
    private val indenter: Indenter,
    private val shiftViewModel: ShiftViewModel,
) {
    private val cursor get() = cursorViewModel.cursor
    private val code get() = codeViewModel.code
    private val isShifted get() = shiftViewModel.isShifted

    fun type(char: Char) {
        val completed = completeBracket(char) // '(' -> "()"
        val newLine = code[cursor.row].insertAt(cursor.col, completed)
        codeViewModel.updateLine(cursor.row, newLine)
        cursorViewModel.update(cursor.row, cursor.col + 1)

        if (isShifted) {
            shiftViewModel.reset()
        }
    }

    fun enter() {
        val (newLines, newCursor) = indenter.indent(code, cursor)
        codeViewModel.replaceLines(cursor.row, newLines)
        cursorViewModel.update(newCursor.row, newCursor.col)
    }

    fun space() {
        val newLine = code[cursor.row].insertAt(cursor.col, " ")
        codeViewModel.updateLine(cursor.row, newLine)
        cursorViewModel.update(cursor.row, cursor.col + 1)
    }

    fun backspace() {
        val currLine = code[cursor.row]

        if (cursor.isAtLineStart()) {
            if (cursor.isAtFirstLine()) return

            val oldUpperLine = code[cursor.row - 1]
            val newUpperLine = oldUpperLine + currLine

            codeViewModel.updateLine(cursor.row - 1, newUpperLine)
            codeViewModel.deleteLine(cursor.row)
            cursorViewModel.update(cursor.row - 1, oldUpperLine.length)
            return
        }

        // Default backspace
        val newLine = currLine.removeAt(cursor.col - 1)
        codeViewModel.updateLine(cursor.row, newLine)
        cursorViewModel.update(cursor.row, cursor.col - 1)
    }

    fun indent() {

    }

    fun unIndent() {
        if (cursor.isAtLineStart()) return

        val delCnt = minOf(4, cursor.col)
        val newLine = code[cursor.row].removeRange(cursor.col - delCnt, cursor.col)
        codeViewModel.updateLine(cursor.row, newLine)
        cursorViewModel.update(cursor.row, cursor.col - delCnt)
    }
}