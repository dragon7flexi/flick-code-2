package com.example.expe.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.expe.ui.config.Dimens

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenWidthDp.dp
}

@Composable
fun getScreenHeight(): Dp {
    val configuration = LocalConfiguration.current
    return configuration.screenHeightDp.dp
}

fun calcKeyboardHeight(width: Dp): Dp {
    return width * Dimens.KEYBOARD_HEIGHT_RATIO
}