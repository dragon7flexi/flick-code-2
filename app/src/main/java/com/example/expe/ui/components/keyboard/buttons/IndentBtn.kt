package com.example.expe.ui.components.keyboard.buttons

import NormalBtn
import androidx.compose.runtime.Composable

@Composable
fun IndentBtn(indent: () -> Unit) {
    NormalBtn { indent() }
}