import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.expe.logic.ClipboardService
import com.example.expe.ui.components.HomeScreenContent
import com.example.expe.ui.config.ColorOf
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.CursorViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    codeViewModel: CodeViewModel,
    clipboardService: ClipboardService,
    cursorViewModel: CursorViewModel,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = ColorOf.Background,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // innerPadding ensures content does not overlap with the system bars.
            HomeScreenContent(navController, codeViewModel, clipboardService, cursorViewModel)
        }
    }
}
