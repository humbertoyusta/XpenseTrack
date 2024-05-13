package com.humbertoyusta.xpensetrack.ui.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

enum class AuthInputType {
    Email,
    Password
}

@Composable
fun AuthInput(
    type: AuthInputType,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = when (type) {
                    AuthInputType.Email -> "Email"
                    AuthInputType.Password -> "Password"
                },
            )
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = when (type) {
            AuthInputType.Email -> KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
            )

            AuthInputType.Password -> KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            errorContainerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(16.dp),
        visualTransformation = when (type) {
            AuthInputType.Email -> VisualTransformation.None
            AuthInputType.Password -> PasswordVisualTransformation()
        }
    )
}