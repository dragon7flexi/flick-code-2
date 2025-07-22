package com.example.expe.usecase.code

import Cursor

fun completeBracket(char: Char): String {
    return when (char) {
        '(' -> "()"
        '[' -> "[]"
        '{' -> "{}"
        else -> char.toString()
    }
}

fun Cursor.isAfterColon(line: String): Boolean {
    return line.getOrNull(col - 1) == ':'
}

fun Cursor.isSurroundedByBracket(line: String): Boolean {
    val before = line.getOrNull(col - 1)
    val after = line.getOrNull(col)
    return (
        before == '(' && after == ')' ||
        before == '[' && after == ']' ||
        before == '{' && after == '}'
    )
}
