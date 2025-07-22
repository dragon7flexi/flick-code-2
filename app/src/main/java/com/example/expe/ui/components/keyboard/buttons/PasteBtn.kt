import androidx.compose.runtime.Composable

@Composable
fun PasteBtn(paste: () -> Unit) {
    NormalBtn { paste() }
}