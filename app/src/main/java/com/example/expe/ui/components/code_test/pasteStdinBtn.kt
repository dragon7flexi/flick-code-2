import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.expe.ui.config.CustomColor

@Composable
fun PasteStdinBtn(pasteStdin: () -> Unit) {
    Button(
        onClick = { pasteStdin() },
    ) {
        Text("Paste")
    }
}