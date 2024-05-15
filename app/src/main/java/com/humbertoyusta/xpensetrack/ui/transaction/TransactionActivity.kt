package com.humbertoyusta.xpensetrack.add_transaction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.add_transaction.ui.TransactionScreen
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.ui.shared.TransactionViewModel
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class TransactionActivity : ComponentActivity() {
    private val transactionViewModel: TransactionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                TransactionScreen(
                    onSave = { transaction: Transaction ->
                        transactionViewModel.insertTransaction(transaction)
                        finish()
                    },
                )
            }
        }
    }
}

@Composable
@Preview
fun AddTransactionScreenPreview() {
    XpenseTrackTheme {
        TransactionScreen(onSave = {})
    }
}