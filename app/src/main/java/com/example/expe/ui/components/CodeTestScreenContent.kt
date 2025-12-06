package com.example.expe.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.expe.ui.components.`code-test`.StdinForm
import com.example.expe.ui.components.code_test.RunTestBtn
import com.example.expe.ui.screen.navigation.Routes
import com.example.expe.usecase.code.executor.PythonExecutor
import com.example.expe.viewmodel.CodeViewModel
import com.example.expe.viewmodel.StdinViewModel
import kotlinx.coroutines.launch

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun CodeTestScreenContent(
    navController: NavController,
    codeViewModel: CodeViewModel,
    stdinViewModel: StdinViewModel,
) {
    val pythonExecutor = PythonExecutor()

    var stdout by remember { mutableStateOf("") }
    var stderr by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        StdinForm(stdinViewModel)
        Row {
            Button(onClick = { navController.navigate(Routes.HOME) }) {
                Text("Home")
            }
            RunTestBtn {
                val code = codeViewModel.code.joinToString(separator = "\n")
                val result = pythonExecutor.run(code, stdinViewModel.text)

                stdout = result.stdout
                stderr = result.stderr
            }
        }
        Text(stdout, color = Color.White)
        Text(stderr, color = Color.White)
    }
}
