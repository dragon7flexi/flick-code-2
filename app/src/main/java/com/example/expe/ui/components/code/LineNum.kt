package com.example.expe.ui.components.code

import com.example.expe.ui.config.FontOf
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.expe.ui.config.Dimens

@Composable
fun LineNum(lineNum: Int, backgroundColor: Color) {
    Text(
        text = lineNum.toString(),
        modifier = Modifier.width(Dimens.LineNumWidth),
        textAlign = TextAlign.Center,
        fontSize = Dimens.LineNumFontSize,
        color = backgroundColor,
        fontFamily = FontOf.LineNum,
    )
}