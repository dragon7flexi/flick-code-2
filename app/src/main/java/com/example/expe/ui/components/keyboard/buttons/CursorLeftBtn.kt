import androidx.compose.runtime.Composable

@Composable
fun CursorLeftBtn(cursorLeft: () -> Unit) {
    LongPressBtn { cursorLeft() }
}