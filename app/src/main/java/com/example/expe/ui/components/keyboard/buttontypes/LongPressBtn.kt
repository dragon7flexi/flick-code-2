import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LongPressBtn(action: () -> Unit) {
    Box(
        modifier = Modifier
            .keyBtnStyle()
            .repeatOnLongPress(action, Times.RepeatInterval, Times.LongPressFirstDelay)
    )
}
