package com.humbertoyusta.xpensetrack.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.data.Transaction
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.home.ui.HomeScreen

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transactions: List<Transaction> = listOf()
        setContent {
            HomeScreen(transactions)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

    val transactions = listOf(
        Transaction(
            category = "Groceries",
            amount = 50.0,
            date = "Today",
            type = TransactionType.EXPENSE
        ),
        Transaction(
            category = "Salary",
            amount = 1000.0,
            date = "Yesterday",
            type = TransactionType.INCOME
        ),
        Transaction(
            category = "Rent",
            amount = 500.0,
            date = "Yesterday",
            type = TransactionType.EXPENSE
        ),
        Transaction(
            category = "Shopping",
            amount = 200.0,
            date = "Yesterday",
            type = TransactionType.EXPENSE
        ),
        Transaction(
            category = "Freelance",
            amount = 300.0,
            date = "Yesterday",
            type = TransactionType.INCOME
        ),
    )

    HomeScreen(transactions = transactions)
}