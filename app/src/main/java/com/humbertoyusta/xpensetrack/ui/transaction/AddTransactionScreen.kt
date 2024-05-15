package com.humbertoyusta.xpensetrack.add_transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.data.enums.TransactionCategory
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import com.humbertoyusta.xpensetrack.data.model.Transaction
import com.humbertoyusta.xpensetrack.ui.shared.MainButton
import java.util.Date

@Composable
fun AddTransactionScreen(
    onSave: (transaction: Transaction) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    val amount = remember { mutableStateOf("") }
    val transactionType: MutableState<TransactionType> =
        remember { mutableStateOf(TransactionType.EXPENSE) }
    val transactionCategory: MutableState<TransactionCategory?> =
        remember { mutableStateOf(null) }

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
                    text = "Add Transaction",
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
                MainButton(
                    text = "Save",
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
            }
        }
    }
}