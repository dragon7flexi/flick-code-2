import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.awaitTouchSlopOrCancellation
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.coroutineScope
import kotlin.math.abs

fun Modifier.flickable(
    up: Char,
    left: Char,
    center: Char,
    right: Char,
    down: Char,
    onFlick: (Char) -> Unit
): Modifier = this.then(
    Modifier.pointerInput(Unit) {
        coroutineScope {
            while (true) {
                val downEvent = awaitPointerEventScope { awaitFirstDown() }
                val result = awaitPointerEventScope {
                    awaitTouchSlopOrCancellation(downEvent.id) { change, dragAmount ->
                        change.consume()

                        val (dx, dy) = dragAmount
                        val direction = determineDirection(dx, dy)

                        val selected = when (direction) {
                            Direction.UP -> up
                            Direction.DOWN -> down
                            Direction.LEFT -> left
                            Direction.RIGHT -> right
                            Direction.NONE -> center
                        }

                        onFlick(selected)
                    }
                }

                if (result == null) {
                    // Not enough drag → treat as tap (center)
                    onFlick(center)
                }
            }
        }
    }
)

private enum class Direction { UP, DOWN, LEFT, RIGHT, NONE }

private fun determineDirection(dx: Float, dy: Float): Direction {
    return if (abs(dx) > abs(dy)) {
        if (dx > 0) Direction.RIGHT else Direction.LEFT
    } else {
        if (dy > 0) Direction.DOWN else Direction.UP
    }
}
