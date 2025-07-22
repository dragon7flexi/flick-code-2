import androidx.compose.runtime.Composable

@Composable
fun CursorRightBtn(cursorRight: () -> Unit) {
    LongPressBtn { cursorRight() }
}