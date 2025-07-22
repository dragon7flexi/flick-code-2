import androidx.compose.runtime.Composable

@Composable
fun BackspaceBtn(backspace: () -> Unit) {
    LongPressBtn { backspace() }
}