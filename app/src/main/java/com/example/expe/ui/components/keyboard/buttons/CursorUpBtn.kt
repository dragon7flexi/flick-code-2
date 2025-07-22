import androidx.compose.runtime.Composable

@Composable
fun CursorUpBtn(cursorUp: () -> Unit) {
    LongPressBtn { cursorUp() }
}