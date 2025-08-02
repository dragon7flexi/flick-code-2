import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.expe.ui.config.Dimens
import com.example.expe.ui.config.FontOf

@Composable
fun getCharWidthPx(): Float {
    val textMeasurer = rememberTextMeasurer()

    return remember {
        textMeasurer.measure(
            text = AnnotatedString("A"),
            style = TextStyle(
                fontSize = Dimens.CodeFontSize,
                fontFamily = FontOf.Code,
            ),
        ).size.width.toFloat()
    }
}
