package com.humbertoyusta.xpensetrack.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    isDanger: Boolean = false,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .background(
                    brush = if (isDanger)
                        Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.errorContainer,
                                MaterialTheme.colorScheme.error
                            )
                        )
                    else
                        Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary,
                            )
                        ),
                    alpha = if (enabled) 1f else 0.5f,
                )
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = if (isDanger)
                    MaterialTheme.colorScheme.onError
                else
                    MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}
