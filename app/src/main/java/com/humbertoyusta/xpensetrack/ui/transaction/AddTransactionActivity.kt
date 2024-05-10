package com.humbertoyusta.xpensetrack.add_transaction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.humbertoyusta.xpensetrack.add_transaction.ui.AddTransactionScreen
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class AddTransactionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                AddTransactionScreen()
            }
        }
    }
}