package com.humbertoyusta.xpensetrack.ui.transaction

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.humbertoyusta.xpensetrack.data.enums.TransactionType
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class IncomeExpenseSelectTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun incomeExpenseSelect_IncomeButton_ChangesFromExpense() {
        // Arrange: Create state
        val transactionType = mutableStateOf(TransactionType.EXPENSE)

        // Arrange: Set content
        composeTestRule.setContent {
            IncomeExpenseSelect(transactionType = transactionType)
        }

        // Assert: Initial state
        assert(transactionType.value == TransactionType.EXPENSE)

        // Act: Click on Income button
        composeTestRule.onNodeWithText("Income")
            .performClick()

        // Assert: State changed
        assert(transactionType.value == TransactionType.INCOME)
    }

    @Test
    fun incomeExpenseSelect_ExpenseButton_KeepsStateIfPressed() {
        // Arrange: Create state
        val transactionType = mutableStateOf(TransactionType.EXPENSE)

        // Arrange: Set content
        composeTestRule.setContent {
            IncomeExpenseSelect(transactionType = transactionType)
        }

        // Assert: Initial state
        assert(transactionType.value == TransactionType.EXPENSE)

        // Act: Click on Expense button
        composeTestRule.onNodeWithText("Expense")
            .performClick()

        // Assert: State unchanged
        assert(transactionType.value == TransactionType.EXPENSE)
    }
}
