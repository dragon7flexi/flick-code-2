import androidx.compose.runtime.Composable

@Composable
fun CursorDownBtn(cursorDown: () -> Unit) {
    LongPressBtn { cursorDown() }
}