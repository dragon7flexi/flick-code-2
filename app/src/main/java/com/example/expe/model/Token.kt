package com.example.expe.model

data class Token(
    val type: TokenType,
    val text: String,
)

enum class TokenType {
    KeywordBlue,
    KeywordGreen,
    KeywordPink,
    Str,
    Number,
    Function,
    Bracket,
    Operator,
    Others,
}