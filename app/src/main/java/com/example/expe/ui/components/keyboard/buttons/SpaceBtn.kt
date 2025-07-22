import androidx.compose.runtime.Composable

@Composable
fun SpaceBtn(space: () -> Unit) {
    NormalBtn { space() }
}