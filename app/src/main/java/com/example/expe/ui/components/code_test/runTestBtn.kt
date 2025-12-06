package com.example.expe.ui.components.code_test

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RunTestBtn(runTest: () -> Unit) {
    Button(onClick = { runTest() }) {
        Text("Run")
    }
}