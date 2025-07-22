package com.example.expe.ui.components.code

import LineContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.expe.model.Token
import com.example.expe.ui.config.Dimens

@Composable
fun CodeLine(
    lineNum: Int,
    tokens: List<Token>,
    lineNumBackgroundColor: Color,
) {
    Row(
        modifier = Modifier.height(Dimens.LineHeight),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LineNum(lineNum, lineNumBackgroundColor)
        LineContent(tokens)
    }
}