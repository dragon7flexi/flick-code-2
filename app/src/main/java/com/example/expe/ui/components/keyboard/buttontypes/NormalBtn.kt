import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NormalBtn(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .keyBtnStyle()
            .clickable(onClick = onClick)
    )
}