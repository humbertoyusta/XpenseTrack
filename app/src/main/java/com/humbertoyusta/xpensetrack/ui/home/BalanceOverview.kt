package com.humbertoyusta.xpensetrack.home.ui

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.ui.theme.Green
import com.humbertoyusta.xpensetrack.ui.theme.Red

@Composable
fun BalanceOverview(balance: String, income: String, expenses: String) {
    Card(
        shape = RoundedCornerShape(36.dp),
        elevation = CardDefaults.cardElevation(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(36.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        ),
                        tileMode = TileMode.Clamp
                    )
                )
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Balance",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary
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
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(14.dp)
                )
                .padding(5.dp)
                .size(18.dp),
            tint = if (type == TransactionType.INCOME) Green else Red
        )
        Column(
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Text(
                text = if (type == TransactionType.INCOME) "Income" else "Expenses",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimary
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