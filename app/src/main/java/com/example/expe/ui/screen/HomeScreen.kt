import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.expe.ui.components.HomeScreenContent
import com.example.expe.ui.config.ColorOf

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorOf.Background,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // innerPadding ensures content does not overlap with the system bars.
            HomeScreenContent()
        }
    }
}
