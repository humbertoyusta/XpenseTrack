package com.humbertoyusta.xpensetrack.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.humbertoyusta.xpensetrack.data.Transaction
import com.humbertoyusta.xpensetrack.home.ui.HomeScreen

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transactions: List<Transaction> = listOf()
        setContent {
            HomeScreen(transactions)
        }
    }
}