package com.humbertoyusta.xpensetrack.data

import com.humbertoyusta.xpensetrack.data.enums.TransactionType

data class Transaction(
    val category: String,
    val amount: Double,
    val type: TransactionType,
    val date: String,
)
