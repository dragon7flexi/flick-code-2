package com.example.expe.usecase

import com.example.expe.usecase.clipboard.Clipboard
import com.example.expe.viewmodel.ShiftViewModel
import android.content.Context
import com.example.expe.logic.ClipboardService
import com.example.expe.usecase.code.CodeEditor
import com.example.expe.usecase.code.Indenter
import com.example.expe.usecase.cursor.CursorNavigator
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.CursorViewModel

fun createEditorController(
    context: Context,
    codeViewModel: CodeViewModel,
    cursorViewModel: CursorViewModel,
    shiftViewModel: ShiftViewModel
): EditorController {
    val indenter = Indenter()
    val codeEditor = CodeEditor(codeViewModel, cursorViewModel, indenter, shiftViewModel)
    val cursorNavigator = CursorNavigator(cursorViewModel, codeViewModel)
    val clipboardService = ClipboardService(context)
    val clipboard = Clipboard(codeViewModel, clipboardService, cursorViewModel)

    return EditorControllerImpl(
        codeEditor,
        cursorNavigator,
        clipboard,
        shiftViewModel
    )
}
