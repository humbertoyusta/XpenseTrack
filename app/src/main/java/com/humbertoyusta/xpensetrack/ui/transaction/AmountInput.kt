package com.humbertoyusta.xpensetrack.add_transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R

private const val DIGITS = "0123456789."

@Composable
fun AmountInput(
    amount: MutableState<String>,
    focusManager: FocusManager,
) {
    TextField(
        value = amount.value,
        onValueChange = {
            // Only allow digits, at most one decimal point
            // and at most two places after the decimal point
            if (it.all { char -> char in DIGITS } &&
                it.count { char -> char == '.' } <= 1 &&
                (it.indexOf('.') == -1 || it.length - it.indexOf('.') <= 3)
            ) {
                amount.value = it
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Decimal,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_euro_symbol),
                contentDescription = "Euro Symbol"
            )
        },
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(50)
            )
            .padding(12.dp),
        textStyle = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            errorContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            disabledIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
            errorTextColor = MaterialTheme.colorScheme.error,
            disabledTextColor = MaterialTheme.colorScheme.primary,
        ),
        placeholder = {
            Text(
                text = "Amount",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        },
        singleLine = true
    )
}