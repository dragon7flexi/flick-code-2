package com.example.expe.utils

import androidx.compose.ui.unit.Dp

fun calcVisibleLines(screenHeight: Dp, lineHeight: Dp): Int {
    return (screenHeight / lineHeight).toInt()
}

fun calcScrolledLines(
    cursorRow: Int,
    lineTotal: Int,
    visibleLines: Int,
): Int {
    val half = visibleLines / 2
    val maxScroll = maxOf(0, lineTotal - visibleLines)
    return (cursorRow - half).coerceIn(0, maxScroll)
}


fun extractVisibleCode(
    code: List<String>,
    startLine: Int,
    visibleLines: Int,
): List<String> {
    val endLine = (startLine + visibleLines).coerceAtMost(code.size)
    return code.subList(startLine, endLine)
}
