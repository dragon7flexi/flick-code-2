package com.example.expe.usecase

import com.example.expe.usecase.clipboard.Clipboard
import com.example.expe.usecase.code.CodeEditor
import com.example.expe.usecase.cursor.CursorNavigator
import com.example.expe.viewmodel.ShiftViewModel

interface EditorController {
    // Edit operations
    fun type(char: Char)
    fun enter()
    fun space()
    fun backspace()
    fun indent()
    fun unIndent()

    // Cursor movement
    fun cursorUp()
    fun cursorDown()
    fun cursorLeft()
    fun cursorRight()
    fun cursorToLineStart()
    fun cursorToLineEnd()
    fun cursorMoveBefore(char: Char)
    fun cursorMoveAfter(char: Char)

    // Clipboard
    fun copyAll()
    fun cutAll()
    fun paste()

    // Shift
    fun toggleShift()
}

class EditorControllerImpl(
    private val codeEditor: CodeEditor,
    private val cursorNavigator: CursorNavigator,
    private val clipboard: Clipboard,
    private val shiftViewModel: ShiftViewModel,
): EditorController {
    override fun type(char: Char) {
        codeEditor.type(char)
    }

    override fun enter() {
        codeEditor.enter()
    }

    override fun space() {
        codeEditor.space()
    }

    override fun backspace() {
        codeEditor.backspace()
    }

    override fun indent() {
        codeEditor.indent()
    }

    override fun unIndent() {
        codeEditor.unIndent()
    }

    override fun cursorUp() {
        cursorNavigator.up()
    }

    override fun cursorDown() {
        cursorNavigator.down()
    }

    override fun cursorLeft() {
        cursorNavigator.left()
    }

    override fun cursorRight() {
        cursorNavigator.right()
    }

    override fun cursorToLineStart() {
        cursorNavigator.toLineStart()
    }

    override fun cursorToLineEnd() {
        cursorNavigator.toLineEnd()
    }

    override fun cursorMoveBefore(char: Char) {
        cursorNavigator.moveBefore(char)
    }

    override fun cursorMoveAfter(char: Char) {
        cursorNavigator.moveAfter(char)
    }

    override fun copyAll() {
        clipboard.copyAll()
    }

    override fun cutAll() {
        clipboard.cutAll()
    }

    override fun paste() {
        clipboard.paste()
    }

    override fun toggleShift() {
        shiftViewModel.toggle()
    }
}