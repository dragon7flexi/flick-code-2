import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.delay

fun Modifier.repeatOnLongPress(
    action: () -> Unit,
    repeatInterval: Long,
    firstDelay: Long,
): Modifier = composed {
    // interactionSource is to track user interactions.
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    LaunchedEffect(isPressed) {
        if (!isPressed) return@LaunchedEffect

        action() // First action
        delay(firstDelay)

        while (isPressed) { // Start repeat
            action()
            delay(repeatInterval)
        }
    }

    this.then(
        Modifier.clickable(
            interactionSource = interactionSource,
            indication = null, // null because No UI feedback needed
            onClick = {} // No-op; handled by the LaunchedEffect
        )
    )
}
