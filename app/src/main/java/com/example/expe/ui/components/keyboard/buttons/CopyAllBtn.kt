import androidx.compose.runtime.Composable

@Composable
fun CopyAllBtn(copyAll: () -> Unit) {
    NormalBtn { copyAll() }
}