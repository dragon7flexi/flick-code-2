package com.example.expe.ui.components.`code-test`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.expe.ui.config.CustomColor
import com.example.expe.viewmodel.StdinViewModel

@Composable
fun StdinForm(viewModel: StdinViewModel){
    TextField(
        value = viewModel.text,
        onValueChange = { viewModel.update(it) },
        modifier = Modifier
            .fillMaxWidth()
            .background(CustomColor.MiddleGray),
        textStyle = TextStyle(color = Color.White),
        maxLines = 5,
        colors = defaultTextFieldColors(
            focusedContainerColor =  Color(50, 50, 50),
            unfocusedContainerColor = Color(50, 50, 50),
        )
    )
}

@Composable
fun defaultTextFieldColors(
    focusedContainerColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
    unfocusedContainerColor: Color = MaterialTheme.colorScheme.surface,
    disabledContainerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    errorContainerColor: Color = MaterialTheme.colorScheme.error.copy(alpha = 0.1f),
    focusedTextColor: Color = MaterialTheme.colorScheme.onSurface,
    unfocusedTextColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
): TextFieldColors {
    return TextFieldColors(
        focusedTextColor = focusedTextColor,
        unfocusedTextColor = unfocusedTextColor,
        disabledTextColor = unfocusedTextColor,
        errorTextColor = MaterialTheme.colorScheme.error,
        focusedContainerColor = focusedContainerColor,
        unfocusedContainerColor = unfocusedContainerColor,
        disabledContainerColor = disabledContainerColor,
        errorContainerColor = errorContainerColor,
        cursorColor = MaterialTheme.colorScheme.primary,
        errorCursorColor = MaterialTheme.colorScheme.error,
        textSelectionColors = TextSelectionColors(
            handleColor = MaterialTheme.colorScheme.primary,
            backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
        ),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = MaterialTheme.colorScheme.error,
        focusedLeadingIconColor = focusedTextColor,
        unfocusedLeadingIconColor = unfocusedTextColor,
        disabledLeadingIconColor = unfocusedTextColor,
        errorLeadingIconColor = MaterialTheme.colorScheme.error,
        focusedTrailingIconColor = focusedTextColor,
        unfocusedTrailingIconColor = unfocusedTextColor,
        disabledTrailingIconColor = unfocusedTextColor,
        errorTrailingIconColor = MaterialTheme.colorScheme.error,
        focusedLabelColor = focusedTextColor,
        unfocusedLabelColor = unfocusedTextColor,
        disabledLabelColor = unfocusedTextColor,
        errorLabelColor = MaterialTheme.colorScheme.error,
        focusedPlaceholderColor = focusedTextColor.copy(alpha = 0.5f),
        unfocusedPlaceholderColor = unfocusedTextColor.copy(alpha = 0.5f),
        disabledPlaceholderColor = unfocusedTextColor.copy(alpha = 0.5f),
        errorPlaceholderColor = MaterialTheme.colorScheme.error.copy(alpha = 0.5f),
        focusedSupportingTextColor = focusedTextColor,
        unfocusedSupportingTextColor = unfocusedTextColor,
        disabledSupportingTextColor = unfocusedTextColor,
        errorSupportingTextColor = MaterialTheme.colorScheme.error,
        focusedPrefixColor = focusedTextColor,
        unfocusedPrefixColor = unfocusedTextColor,
        disabledPrefixColor = unfocusedTextColor,
        errorPrefixColor = MaterialTheme.colorScheme.error,
        focusedSuffixColor = focusedTextColor,
        unfocusedSuffixColor = unfocusedTextColor,
        disabledSuffixColor = unfocusedTextColor,
        errorSuffixColor = MaterialTheme.colorScheme.error
    )
}
