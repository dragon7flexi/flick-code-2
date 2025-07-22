import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun dpToPx(dp: Dp): Float {
    val density = LocalDensity.current
    return remember(dp, density) {
        with(density) { dp.toPx() }
    }
}
