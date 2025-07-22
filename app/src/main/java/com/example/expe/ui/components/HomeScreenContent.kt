package com.example.expe.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.expe.data.CodeRepository
import com.example.expe.ui.components.code.Code
import com.example.expe.ui.components.keyboard.KeyBoard
import com.example.expe.ui.components.cursor.Cursor
import com.example.expe.ui.config.ColorOf
import com.example.expe.ui.config.Dimens
import com.example.expe.usecase.createEditorController
import com.example.expe.utils.calcScrolledLines
import com.example.expe.utils.calcTopLeftX
import com.example.expe.utils.calcTopLeftY
import com.example.expe.utils.calcVisibleLines
import com.example.expe.utils.getScreenHeight
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.CursorViewModel
import com.example.expe.viewmodel.ShiftViewModel
import dpToPx
import getCharWidthPx

@Composable
fun HomeScreenContent() {
    val context = LocalContext.current
    val codeRepository = remember(context) { CodeRepository(context) }
    val codeViewModel = remember { CodeViewModel(codeRepository) }
    val cursorViewModel = remember { CursorViewModel() }
    val shiftViewModel = remember { ShiftViewModel() }
    val editorController = createEditorController(context, codeViewModel, cursorViewModel, shiftViewModel)

    val code = codeViewModel.code
    val cursor = cursorViewModel.cursor

    val lineHeight = Dimens.LineHeight
    val screenHeight = getScreenHeight()
    val visibleLines = calcVisibleLines(screenHeight, lineHeight)
    val scrolledLines = calcScrolledLines(cursor.row, code.size, visibleLines)

    val lineHeightPx = dpToPx(Dimens.LineHeight)
    val charWidthPx = getCharWidthPx()
    val lineNumWidthPx = dpToPx(Dimens.LineNumWidth)
    val topLeftX = calcTopLeftX(cursor.col, charWidthPx, lineNumWidthPx)
    val topLeftY = calcTopLeftY(cursor.row, scrolledLines, lineHeightPx)

    val isShifted = shiftViewModel.isShifted
    val lineNumColor = if (isShifted) ColorOf.ShiftedLineNum else ColorOf.DefaultLineNum

    val tokens = codeViewModel.tokens
    val visibleTokens = tokens.subList(
        scrolledLines,
        minOf(scrolledLines + visibleLines, tokens.size)
    )

    Code(scrolledLines, visibleTokens, lineNumColor)
    Cursor(topLeftX, topLeftY, lineHeightPx)
    KeyBoard(editorController, isShifted)
}
