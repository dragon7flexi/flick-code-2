package com.example.expe.utils

fun calcTopLeftX(col: Int, charWidthPx: Float, lineNumWidthPx: Float): Float {
    return (charWidthPx * col) + lineNumWidthPx
}

fun calcTopLeftY(row: Int, scrolledLine: Int, lineHeightPx: Float): Float {
    return lineHeightPx * (row - scrolledLine)
}
