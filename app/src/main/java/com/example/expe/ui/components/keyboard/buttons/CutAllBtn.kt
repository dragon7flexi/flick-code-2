import androidx.compose.runtime.Composable

@Composable
fun CutAllBtn(cutAll: () -> Unit) {
    NormalBtn { cutAll() }
}