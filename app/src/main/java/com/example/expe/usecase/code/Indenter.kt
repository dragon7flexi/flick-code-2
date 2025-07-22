package com.example.expe.usecase.code

import Cursor

class Indenter {
    fun indent(code: List<String>, cursor: Cursor): Pair<List<String>, Cursor> {
        val line = code[cursor.row]

        return when {
            cursor.isAfterColon(line) -> indentAfterColon(line, cursor)
            cursor.isSurroundedByBracket(line) -> indentWithBracket(line, cursor)
            else -> defaultIndent(line, cursor)
        }
    }

    private fun indentAfterColon(line: String, cursor: Cursor): Pair<List<String>, Cursor> {
        val base = line.takeWhile { it == ' ' } + "    "
        return listOf(
            line.substring(0, cursor.col),
            base + line.substring(cursor.col)
        ) to cursor.copy(row = cursor.row + 1, col = base.length)
    }

    private fun indentWithBracket(line: String, cursor: Cursor): Pair<List<String>, Cursor> {
        val baseIndent = line.takeWhile { it == ' ' }
        val before = line.substring(0, cursor.col)
        val after = line.substring(cursor.col)

        val innerIndent = baseIndent + "    "

        val newLines = listOf(
            before,
            innerIndent,
            baseIndent + after
        )

        val newCursor = cursor.copy(row = cursor.row + 1, col = innerIndent.length)
        return newLines to newCursor
    }

    private fun defaultIndent(line: String, cursor: Cursor): Pair<List<String>, Cursor> {
        val baseIndent = line.takeWhile { it == ' ' }
        val before = line.substring(0, cursor.col)
        val after = line.substring(cursor.col)

        val newLines = listOf(
            before,
            baseIndent + after
        )
        val newCursor = cursor.copy(row = cursor.row + 1, col = baseIndent.length)
        return newLines to newCursor
    }
}
