package com.example.expe.usecase.code.syntaxhighlight

import com.example.expe.model.Token
import com.example.expe.model.TokenType

class Tokenizer {
    private val keywordBlue = setOf("class", "def", "in", "False", "True", "and", "or", "None", "pass")
    private val keywordGreen = setOf("int", "str", "List", "range", "bool", "dict", "float")
    private val keywordPink = setOf("for", "if", "else", "elif", "return", "while", "match", "case", "break", "continue", "from", "import")
    private val brackets = setOf('(', ')', '[', ']', '{', '}')
    private val operators = setOf('+', '-', '*', '/', '%', '=', '>', '<', '!', '&', '|', '^', ':', ';', '.', ',')
    private val regex = Regex("""\s+|\b\w+\b|\".*?\"|\'.*?\'|\d+(\.\d+)?|[^\s]""")

    fun tokenizeLine(line: String): List<Token> {
        val tokens = mutableListOf<Token>()

        for (match in regex.findAll(line)) {
            val text = match.value

            val type = when {
                keywordBlue.contains(text) -> TokenType.KeywordBlue
                keywordGreen.contains(text) -> TokenType.KeywordGreen
                keywordPink.contains(text) -> TokenType.KeywordPink
                text.matches(Regex("""^".*"|'.*'$""")) -> TokenType.Str
                text.matches(Regex("""^\d+(\.\d+)?$""")) -> TokenType.Number
                text.length == 1 && text[0] in brackets -> TokenType.Bracket
                text.length == 1 && text[0] in operators -> TokenType.Operator
                text.matches(Regex("""^[a-zA-Z_][a-zA-Z0-9_]*$""")) && line.contains("$text(") -> TokenType.Function
                else -> TokenType.Others
            }

            tokens.add(Token(type, text))
        }

        return tokens
    }
}
