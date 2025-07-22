package com.example.expe.ui.components.keyboard

import DefaultKeyboard
import ShiftedKeyboard
import androidx.compose.runtime.Composable
import com.example.expe.ui.components.keyboard.layout.KeyboardContainer
import com.example.expe.usecase.EditorController
import com.example.expe.utils.calcKeyboardHeight
import com.example.expe.utils.getScreenWidth

@Composable
fun KeyBoard(
    editorController: EditorController,
    isShifted: Boolean,
) {
    val keyboardWidth = getScreenWidth()
    val keyboardHeight = calcKeyboardHeight(keyboardWidth)

    KeyboardContainer(keyboardWidth, keyboardHeight) {
        if (isShifted) {
            ShiftedKeyboard(editorController)
        } else {
            DefaultKeyboard(editorController)
        }
    }
}