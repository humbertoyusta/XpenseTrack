package com.humbertoyusta.xpensetrack.ui.currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CurrencyRow(
    iconDrawableId: Int,
    currencyCode: String,
    exchangeRate: Double?,
) {
    Row(
        modifier = Modifier
            .padding(top = 24.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp),
            )
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Icon(
            painter = painterResource(id = iconDrawableId),
            contentDescription = currencyCode,
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Text(
                text = exchangeRate?.toString() ?: "...",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = currencyCode,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(
                        bottom = 2.dp,
                        start = 4.dp,
                    )
            )
        }
    }
}