import androidx.compose.runtime.Composable

@Composable
fun GoToCodeTestBtn(goToCodeTest: () -> Unit) {
    NormalBtn { goToCodeTest() }
}