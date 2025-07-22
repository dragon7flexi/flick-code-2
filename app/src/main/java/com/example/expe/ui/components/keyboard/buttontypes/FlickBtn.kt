import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FlickBtn(
    up: Char,
    left: Char,
    center: Char,
    right: Char,
    down: Char,
    type: (char: Char) -> Unit,
) {
    Box(
        modifier = Modifier
            .keyBtnStyle()
            .flickable(up, left, center, right, down) { selected ->
                type(selected)
            }
    )
}