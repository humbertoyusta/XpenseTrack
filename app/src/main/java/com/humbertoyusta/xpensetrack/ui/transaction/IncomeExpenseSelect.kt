package com.humbertoyusta.xpensetrack.ui.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.data.enums.TransactionType

@Composable
fun IncomeExpenseSelect(
    transactionType: MutableState<TransactionType>
) {
    val selectedGradient = Brush.horizontalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary
        )
    )
    val surfaceGradient = Brush.horizontalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.surface
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp),
            )
    ) {

        // Income button
        Button(
            onClick = { transactionType.value = TransactionType.INCOME },
            modifier = Modifier
                .weight(0.5f)
                .padding(4.dp),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = stringResource(id = R.string.income),
                modifier = Modifier
                    .background(
                        if (transactionType.value == TransactionType.INCOME)
                            selectedGradient else surfaceGradient
                    )
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                color = if (transactionType.value == TransactionType.INCOME)
                    MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        // Expense button
        Button(
            onClick = { transactionType.value = TransactionType.EXPENSE },
            modifier = Modifier
                .weight(0.5f)
                .padding(4.dp)
                .align(Alignment.CenterVertically),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
        ) {
            Text(
                text = stringResource(id = R.string.expense),
                modifier = Modifier
                    .background(
                        if (transactionType.value == TransactionType.EXPENSE)
                            selectedGradient else surfaceGradient
                    )
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                color = if (transactionType.value == TransactionType.EXPENSE)
                    MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}