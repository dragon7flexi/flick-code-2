package com.example.expe.ui.components.cursor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import com.example.expe.ui.config.ColorOf
import com.example.expe.ui.config.Dimens
import dpToPx

@Composable
fun Cursor(
    topLeftX: Float,
    topLeftY: Float,
    lineHeightPx: Float,
) {
    val cursorWidthPx = dpToPx(Dimens.CursorWidth)

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(
            color = ColorOf.Cursor,
            topLeft = Offset(topLeftX, topLeftY),
            size = Size(
                width = cursorWidthPx,
                height = lineHeightPx,
            )
        )
    }
}