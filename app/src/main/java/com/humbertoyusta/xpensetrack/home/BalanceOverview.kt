package com.humbertoyusta.xpensetrack.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.types.TransactionType

@Composable
fun BalanceOverview(balance: String, income: String, expenses: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(36.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.tertiary
                    )
                )
            )
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Total Balance",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = "$$balance",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Row(
            modifier = Modifier
                .padding(top = 36.dp, start = 24.dp, end = 36.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IncomeExpensesInfo(TransactionType.INCOME, income)
            IncomeExpensesInfo(TransactionType.EXPENSE, expenses)
        }
    }
}

@Composable
fun IncomeExpensesInfo(type: TransactionType, amount: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = if (type == TransactionType.INCOME) R.drawable.round_arrow_upward else R.drawable.round_arrow_downward),
            contentDescription = "Income",
            modifier = Modifier
                .padding(4.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(12.dp),
                )
                .padding(4.dp)
                .size(16.dp),
        )
        Column(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Text(
                text = if (type == TransactionType.INCOME) "Income" else "Expenses",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$$amount",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}