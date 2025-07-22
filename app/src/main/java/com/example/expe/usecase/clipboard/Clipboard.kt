package com.example.expe.usecase.clipboard

import com.example.expe.logic.ClipboardService
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.CursorViewModel

class Clipboard(
    private val codeViewModel: CodeViewModel,
    private val clipboardService: ClipboardService,
    private val cursorViewModel: CursorViewModel,
) {
    fun copyAll() {
        val code = codeViewModel.code
        clipboardService.copy(code)
    }

    fun cutAll() {
        copyAll()
        codeViewModel.deleteAll()
        cursorViewModel.reset()
    }

    fun paste() {
        val lines = clipboardService.getLines() ?: return
        codeViewModel.updateAll(lines)
        cursorViewModel.reset()
    }
}