package com.humbertoyusta.xpensetrack.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

@Composable
fun HomeScreen(transactions: List<Transaction>) {
    XpenseTrackTheme {
        Scaffold(
            bottomBar = { BottomAppBar() }
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 32.dp,
                        end = 32.dp,
                        top = 40.dp,
                        bottom = 0.dp
                    ),
                ) {
                    BalanceOverview(
                        balance = "3000.00",
                        income = "740.50",
                        expenses = "680.00"
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Transactions",
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "View all",
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(transactions.size) { index ->
                            TransactionItem(
                                category = transactions[index].category,
                                amount = transactions[index].amount.toString(),
                                date = transactions[index].date.toString(),
                                type = transactions[index].type
                            )
                        }
                    }
                }
            }
        }
    }
}