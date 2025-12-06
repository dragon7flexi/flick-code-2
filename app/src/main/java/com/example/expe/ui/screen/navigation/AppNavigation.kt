package com.example.expe.ui.screen.navigation

import CodeTestScreen
import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.expe.data.CodeRepository
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.StdinViewModel

object Routes {
    const val HOME = "home"
    const val CODE_TEST = "code-test"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val codeRepository = remember(context) { CodeRepository(context) }
    val codeViewModel = remember { CodeViewModel(codeRepository) }

    val stdinViewModel = remember { StdinViewModel() }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(Routes.HOME) { HomeScreen(navController, context, codeViewModel) }
        composable(Routes.CODE_TEST) { CodeTestScreen(navController, codeViewModel, stdinViewModel) }
    }
}
