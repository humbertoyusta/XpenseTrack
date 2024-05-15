package com.humbertoyusta.xpensetrack.ui.home

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.home.ui.TransactionItem
import com.humbertoyusta.xpensetrack.ui.shared.Action
import com.humbertoyusta.xpensetrack.ui.shared.Activity
import com.humbertoyusta.xpensetrack.ui.shared.BottomAppBar
import com.humbertoyusta.xpensetrack.ui.shared.TopBar
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun HomeScreen(
    transactions: List<Transaction>,
    logOut: () -> Unit = {},
    onEdit: (transaction: Transaction) -> Unit,
) {
    XpenseTrackTheme {
        Scaffold(
            bottomBar = { BottomAppBar(selectedActivity = Activity.HOME) },
            topBar = {
                TopBar(
                    action = Action.LogOut,
                    logOut = { logOut() },
                )
            }
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
                        top = 0.dp,
                        bottom = 0.dp
                    ),
                ) {
                    BalanceOverview(
                        // sum all transactions amount
                        balance = transactions.sumOf { t ->
                            if (t.type == TransactionType.INCOME) t.amount
                            else -t.amount
                        }.toString(),
                        income = transactions.sumOf { t ->
                            if (t.type == TransactionType.INCOME) t.amount
                            else 0.0
                        }.toString(),
                        expenses = transactions.sumOf { t ->
                            if (t.type == TransactionType.INCOME) 0.0
                            else -t.amount
                        }.toString()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(R.string.transactions),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    val dateFormatter = SimpleDateFormat("MMM dd", Locale.US)
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(transactions.size) { index ->
                            TransactionItem(
                                category = transactions[index].category,
                                amount = transactions[index].amount.toString(),
                                date = dateFormatter.format(transactions[index].date),
                                type = transactions[index].type,
                                onClick = { onEdit(transactions[index]) },
                            )
                        }
                    }
                }
            }
        }
    }
}