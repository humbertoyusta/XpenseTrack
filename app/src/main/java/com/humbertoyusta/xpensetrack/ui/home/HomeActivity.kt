package com.humbertoyusta.xpensetrack.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.home.ui.HomeScreen
import com.humbertoyusta.xpensetrack.ui.shared.TransactionViewModel
import java.util.Date

class HomeActivity : ComponentActivity() {
    private val transactionViewModel: TransactionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val transactions =
                transactionViewModel.getAllTransactions().observeAsState(initial = emptyList())
            HomeScreen(transactions.value)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {

    val transactions = listOf(
        Transaction(
            id = 1,
            category = "Groceries",
            amount = 50.0,
            date = Date(),
            type = TransactionType.EXPENSE
        ),
        Transaction(
            id = 2,
            category = "Salary",
            amount = 1000.0,
            date = Date(),
            type = TransactionType.INCOME
        ),
        Transaction(
            id = 3,
            category = "Rent",
            amount = 500.0,
            date = Date(),
            type = TransactionType.EXPENSE
        ),
        Transaction(
            id = 4,
            category = "Shopping",
            amount = 200.0,
            date = Date(),
            type = TransactionType.EXPENSE
        ),
        Transaction(
            id = 5,
            category = "Freelance",
            amount = 300.0,
            date = Date(),
            type = TransactionType.INCOME
        ),
    )

    HomeScreen(transactions = transactions)
}