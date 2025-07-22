import androidx.compose.runtime.Composable

@Composable
fun EnterBtn(enter: () -> Unit) {
    NormalBtn { enter() }
}