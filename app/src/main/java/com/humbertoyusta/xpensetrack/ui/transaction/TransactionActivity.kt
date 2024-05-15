package com.humbertoyusta.xpensetrack.ui.transaction

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.ui.shared.TransactionViewModel
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme
import com.humbertoyusta.xpensetrack.utils.TRANSACTION_KEY

class TransactionActivity : ComponentActivity() {
    private val transactionViewModel: TransactionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transaction = intent.getParcelableExtra<Transaction>(TRANSACTION_KEY)

        setContent {
            XpenseTrackTheme {
                TransactionScreen(
                    transactionScreenMode = if (transaction == null)
                        TransactionScreenMode.ADD
                    else
                        TransactionScreenMode.EDIT,
                    onSave = { transaction: Transaction ->
                        transactionViewModel.insertTransaction(transaction)
                        Toast.makeText(
                            this,
                            getString(R.string.transaction_added), Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    },
                    onEdit = { transaction: Transaction ->
                        transactionViewModel.updateTransaction(transaction)
                        Toast.makeText(
                            this,
                            getString(R.string.transaction_updated), Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    },
                    onDelete = { transaction: Transaction ->
                        transactionViewModel.deleteTransaction(transaction)
                        Toast.makeText(
                            this,
                            getString(R.string.transaction_deleted), Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    },
                    transaction = transaction,
                )
            }
        }
    }
}

@Composable
@Preview
fun AddTransactionScreenPreview() {
    XpenseTrackTheme {
        TransactionScreen(
            transactionScreenMode = TransactionScreenMode.ADD,
            onSave = {},
            onEdit = {},
            onDelete = {},
            transaction = null
        )
    }
}