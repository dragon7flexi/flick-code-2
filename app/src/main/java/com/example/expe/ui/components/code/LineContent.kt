import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.withStyle
import com.example.expe.model.Token
import com.example.expe.model.TokenType
import com.example.expe.ui.config.ColorOf
import com.example.expe.ui.config.Dimens
import com.example.expe.ui.config.FontOf

@Composable
fun LineContent(tokens: List<Token>) {
    val annotatedString: AnnotatedString = buildAnnotatedString {
        tokens.forEach { token ->
            val color = when (token.type) {
                TokenType.KeywordBlue -> ColorOf.KeywordBlue
                TokenType.KeywordGreen -> ColorOf.KeywordGreen
                TokenType.KeywordPink -> ColorOf.KeywordPink
                TokenType.Number -> ColorOf.Number
                TokenType.Function -> ColorOf.Function
                TokenType.Operator -> ColorOf.Operator
                TokenType.Str -> ColorOf.Str
                TokenType.Bracket -> ColorOf.Bracket
                TokenType.Others -> ColorOf.Others
            }
            withStyle(style = SpanStyle(color = color, fontFamily = FontOf.Code)) {
                append(token.text)
            }
        }
    }

    BasicText(
        text = annotatedString,
        style = TextStyle(fontSize = Dimens.CodeFontSize)
    )
}
