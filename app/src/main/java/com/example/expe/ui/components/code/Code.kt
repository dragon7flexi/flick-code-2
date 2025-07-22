package com.example.expe.ui.components.code

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.expe.model.Token

@Composable
fun Code(
    startLineNum: Int,
    visibleTokens: List<List<Token>>,
    lineNumBackgroundColor: Color,
) {
    Column {
        visibleTokens.forEachIndexed { idx, tokens ->
            CodeLine(
                lineNum = startLineNum + idx + 1,
                tokens = tokens,
                lineNumBackgroundColor,
            )
        }
    }
}