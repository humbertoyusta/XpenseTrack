package com.humbertoyusta.xpensetrack.utils

fun displayAmount(balance: String): String {
    return if (balance[0] == '-')
        "-€${balance.replaceFirstChar { _ -> "" }}"
    else
        "€$balance"
}