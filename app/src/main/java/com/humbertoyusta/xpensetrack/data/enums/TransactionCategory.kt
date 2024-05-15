package com.humbertoyusta.xpensetrack.data.enums

enum class TransactionCategory {
    // Expense categories
    FOOD,
    TRANSPORT,
    SHOPPING,
    BILLS,
    ENTERTAINMENT,
    HEALTH,

    // Income categories
    SALARY,
    GIFT,

    // Common categories
    OTHER;

    companion object expenseCategories {
        fun expenseCategories(): List<TransactionCategory> {
            return listOf(
                FOOD,
                TRANSPORT,
                SHOPPING,
                BILLS,
                ENTERTAINMENT,
                HEALTH,
                OTHER
            )
        }

        fun incomeCategories(): List<TransactionCategory> {
            return listOf(
                SALARY,
                GIFT,
                OTHER
            )
        }
    }
}