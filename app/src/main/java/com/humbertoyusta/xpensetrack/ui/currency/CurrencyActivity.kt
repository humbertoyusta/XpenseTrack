package com.humbertoyusta.xpensetrack.ui.currency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.humbertoyusta.xpensetrack.ui.theme.XpenseTrackTheme

class CurrencyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XpenseTrackTheme {
                CurrencyScreen()
            }
        }
    }
}

@Composable
@Preview
fun CurrencyActivityPreview() {
    XpenseTrackTheme {
        CurrencyScreen()
    }
}