import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.expe.ui.components.CodeTestScreenContent
import com.example.expe.ui.config.ColorOf
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.StdinViewModel

@Composable
fun CodeTestScreen(
    navController: NavController,
    codeViewModel: CodeViewModel,
    stdinViewModel: StdinViewModel
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorOf.Background,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // innerPadding ensures content does not overlap with the system bars.
            CodeTestScreenContent(navController, codeViewModel, stdinViewModel)
        }
    }
}
