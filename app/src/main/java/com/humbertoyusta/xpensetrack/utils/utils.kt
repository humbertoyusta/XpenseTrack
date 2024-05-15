package com.humbertoyusta.xpensetrack.utils

const val TRANSACTION_KEY = "transaction"

fun displayAmount(balance: String): String {
    return if (balance[0] == '-')
        "-€${balance.replaceFirstChar { _ -> "" }}"
    else
        "€$balance"
}