import androidx.compose.runtime.Composable

@Composable
fun ShiftBtn(toggle: () -> Unit) {
    NormalBtn { toggle() }
}