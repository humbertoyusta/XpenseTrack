package com.humbertoyusta.xpensetrack.ui.transaction

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.humbertoyusta.xpensetrack.data.enums.TransactionCategory
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class CategorySelectTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun categorySelect_OpenDropdown_ShowsList() {
        // Arrange: Create state and categories
        val transactionCategory = mutableStateOf<TransactionCategory?>(null)
        val categories = listOf(
            TransactionCategory.FOOD,
            TransactionCategory.TRANSPORT,
            TransactionCategory.SHOPPING,
        )

        // Arrange: Set content
        composeTestRule.setContent {
            CategorySelect(
                transactionCategory = transactionCategory,
                categories = categories
            )
        }

        // Assert: Dropdown is closed
        categories.forEach { category ->
            composeTestRule.onNodeWithText(
                category.name.lowercase().replaceFirstChar { it.uppercase() })
                .assertDoesNotExist()
        }

        // Act: Open dropdown
        composeTestRule.onNodeWithText("Select a category")
            .performClick()

        // Assert: Dropdown is open
        categories.forEach { category ->
            composeTestRule.onNodeWithText(
                category.name.lowercase().replaceFirstChar { it.uppercase() })
                .assertIsDisplayed()
        }
    }

    @Test
    fun categorySelect_SelectCategory_UpdatesStateAndClosesDropdown() {
        // Arrange: Create state and categories
        val transactionCategory = mutableStateOf<TransactionCategory?>(null)
        val categories = listOf(
            TransactionCategory.FOOD,
            TransactionCategory.TRANSPORT,
            TransactionCategory.SHOPPING,
        )

        // Arrange: Set contents
        composeTestRule.setContent {
            CategorySelect(
                transactionCategory = transactionCategory,
                categories = categories
            )
        }

        // Act: Open dropdown
        composeTestRule.onNodeWithText("Select a category")
            .performClick()

        val foodName = TransactionCategory.FOOD.name.lowercase().replaceFirstChar { it.uppercase() }

        // Act: Select category
        composeTestRule.onNodeWithText(foodName).performClick()

        // Assert: State is updated
        assertEquals(TransactionCategory.FOOD, transactionCategory.value)

        // Assert: Dropdown is closed
        categories.forEach { category ->
            val name = category.name.lowercase().replaceFirstChar { it.uppercase() }
            if (name != foodName) {
                composeTestRule.onNodeWithText(name).assertDoesNotExist()
            }
        }
    }
}
