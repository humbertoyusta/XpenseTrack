package com.humbertoyusta.xpensetrack.ui.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.add_transaction.ui.Action
import com.humbertoyusta.xpensetrack.add_transaction.ui.TopBar
import com.humbertoyusta.xpensetrack.data.enums.TransactionCategory
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.ui.shared.MainButton
import java.util.Date

enum class TransactionScreenMode {
    ADD, EDIT
}

@Composable
fun TransactionScreen(
    transactionScreenMode: TransactionScreenMode,
    onSave: (transaction: Transaction) -> Unit,
    onEdit: (transaction: Transaction) -> Unit,
    onDelete: (transaction: Transaction) -> Unit,
    transaction: Transaction? = null,
) {
    val focusManager = LocalFocusManager.current

    val amount = remember { mutableStateOf(transaction?.amount?.toString() ?: "") }
    val transactionType: MutableState<TransactionType> =
        remember { mutableStateOf(transaction?.type ?: TransactionType.EXPENSE) }
    val transactionCategory: MutableState<TransactionCategory?> =
        remember { mutableStateOf(transaction?.category?.let { TransactionCategory.valueOf(it) }) }

    val categories = if (transactionType.value == TransactionType.EXPENSE) {
        TransactionCategory.expenseCategories()
    } else {
        TransactionCategory.incomeCategories()
    }

    if (transactionCategory.value != null &&
        !categories.contains(transactionCategory.value)
    ) {
        transactionCategory.value = null
    }

    Scaffold(
        topBar = { TopBar(action = Action.Close) },
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        focusManager.clearFocus()
                    }
                )
            }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background
                ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 48.dp, start = 36.dp, end = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = if (transactionScreenMode == TransactionScreenMode.ADD)
                        stringResource(id = R.string.add_transaction)
                    else
                        stringResource(id = R.string.edit_transaction),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(24.dp))
                AmountInput(
                    amount = amount,
                    focusManager = focusManager
                )
                Spacer(modifier = Modifier.height(32.dp))
                IncomeExpenseSelect(
                    transactionType = transactionType
                )
                Spacer(modifier = Modifier.height(32.dp))
                CategorySelect(
                    transactionCategory = transactionCategory,
                    categories = categories,
                )
                Spacer(modifier = Modifier.height(32.dp))
                when (transactionScreenMode) {
                    TransactionScreenMode.ADD ->
                        MainButton(
                            text = stringResource(R.string.save),
                            enabled = amount.value.isNotEmpty() && transactionCategory.value != null,
                            onClick = {
                                if (amount.value.isNotEmpty() && transactionCategory.value != null) {
                                    onSave(
                                        Transaction(
                                            id = 0, // Auto-generate will replace this
                                            amount = amount.value.toDouble(),
                                            type = transactionType.value,
                                            category = transactionCategory.value!!.name,
                                            date = Date(),
                                        )
                                    )
                                }
                            }
                        )

                    TransactionScreenMode.EDIT ->
                        Row {
                            Card(
                                modifier = Modifier.weight(1f),
                                elevation = CardDefaults.cardElevation(4.dp),
                            ) {
                                MainButton(
                                    text = stringResource(id = R.string.save),
                                    enabled = amount.value.isNotEmpty() && transactionCategory.value != null,
                                    onClick = {
                                        onEdit(
                                            transaction!!.copy(
                                                amount = amount.value.toDouble(),
                                                type = transactionType.value,
                                                category = transactionCategory.value!!.name,
                                            )
                                        )
                                    }
                                )
                            }
                            Spacer(modifier = Modifier.weight(0.1f))
                            Card(
                                modifier = Modifier.weight(1f),
                                elevation = CardDefaults.cardElevation(4.dp),
                            ) {
                                MainButton(
                                    text = stringResource(R.string.delete),
                                    enabled = true,
                                    onClick = { onDelete(transaction!!) },
                                    isDanger = true
                                )
                            }
                        }
                }
            }
        }
    }
}