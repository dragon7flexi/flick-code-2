package com.example.expe.usecase.cursor

import Cursor
import kotlin.math.min

fun Cursor.isAtFirstLine(): Boolean {
    return row == 0
}

fun Cursor.isAtLastLine(code: List<String>): Boolean {
    return row == code.lastIndex
}

fun Cursor.isAtLineStart(): Boolean {
    return col == 0
}

fun Cursor.isAtLineEnd(line: String): Boolean {
    return col == line.length
}

fun calcColOnUp(cursor: Cursor, code: List<String>): Int {
    val upperLineStrLen = code[cursor.row - 1].length
    return min(cursor.col, upperLineStrLen)
}

fun calcColOnDown(cursor: Cursor, code: List<String>): Int {
    val lowerLineStrLen = code[cursor.row + 1].length
    return min(cursor.col, lowerLineStrLen)
}