package com.example.expe.ui.config

import androidx.compose.ui.graphics.Color

object CustomColor {
    val HardGray = Color(20, 20, 20)
    val MiddleGray = Color(100, 100, 100)
    val SoftGray = Color(150, 150, 150)
    val TranslucentGray = Color(50, 50, 50, 110)
    val LightGreen = Color(144, 238, 144)
    val LightGreenLighter = Color(199, 246, 199)
    val LightBlue = Color(150, 223, 255)
    val Blue = Color(66, 147, 245)
    val Purple = Color(192, 132, 255)
    val Pink = Color(255, 161, 234)
    val Red = Color(255, 92, 92)
    val Orange = Color(255, 135, 61)
    val Yellow = Color(255, 255, 0)
}

object ColorOf {
    val Background = CustomColor.HardGray
    val DefaultLineNum = CustomColor.MiddleGray
    val ShiftedLineNum = CustomColor.LightGreen
    val KeyBtn = CustomColor.TranslucentGray
    val Cursor = CustomColor.SoftGray

    // Syntax highlight
    val KeywordBlue = CustomColor.Blue
    val KeywordGreen = CustomColor.LightGreen
    val KeywordPink = CustomColor.Pink
    val Number = CustomColor.LightGreenLighter
    val Function = CustomColor.Purple
    val Operator = CustomColor.Orange
    val Str = CustomColor.Red
    val Bracket = CustomColor.Yellow
    val Others = CustomColor.LightBlue
}