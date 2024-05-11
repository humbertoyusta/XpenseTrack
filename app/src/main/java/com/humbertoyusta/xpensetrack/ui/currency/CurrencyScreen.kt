package com.humbertoyusta.xpensetrack.ui.currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.humbertoyusta.xpensetrack.add_transaction.ui.TopBar
import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse

@Composable
fun CurrencyScreen(exchangeRates: ExchangeRateResponse?) {
    Scaffold(
        topBar = { TopBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Column {
                Text(
                    text = "1 EUR"
                )
                Text(
                    text = "Equivalences to"
                )
                Text(text = exchangeRates?.conversion_rates?.USD?.toString() ?: "Loading...")
                Text(text = exchangeRates?.conversion_rates?.JPY?.toString() ?: "Loading...")
                Text(text = exchangeRates?.conversion_rates?.GBP?.toString() ?: "Loading...")
                Text(text = exchangeRates?.conversion_rates?.CHF?.toString() ?: "Loading...")
            }
        }
    }
}