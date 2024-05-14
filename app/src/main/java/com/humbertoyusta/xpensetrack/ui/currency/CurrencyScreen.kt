package com.humbertoyusta.xpensetrack.ui.currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.humbertoyusta.xpensetrack.R
import com.humbertoyusta.xpensetrack.add_transaction.ui.Action
import com.humbertoyusta.xpensetrack.add_transaction.ui.TopBar
import com.humbertoyusta.xpensetrack.data.enums.Currency
import com.humbertoyusta.xpensetrack.data.model.ExchangeRateResponse
import com.humbertoyusta.xpensetrack.home.ui.BottomAppBar

@Composable
fun CurrencyScreen(
    exchangeRates: ExchangeRateResponse?,
    logOut: () -> Unit = {},
) {
    Scaffold(
        bottomBar = { BottomAppBar() },
        topBar = { TopBar(action = Action.LogOut, logOut = { logOut() }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 40.dp, vertical = 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(50),
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.baseline_euro_symbol),
                    contentDescription = stringResource(R.string.euro_symbol),
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = "1",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = "EUR",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .padding(
                                bottom = 2.dp,
                                start = 4.dp,
                            )
                    )
                }
            }
            Text(
                text = "Is equivalent to",
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 32.dp),
            )
            CurrencyRow(
                iconDrawableId = R.drawable.round_attach_money,
                currencyCode = Currency.USD.name,
                exchangeRate = exchangeRates?.conversion_rates?.USD,
            )
            CurrencyRow(
                iconDrawableId = R.drawable.round_currency_pound,
                currencyCode = Currency.GBP.name,
                exchangeRate = exchangeRates?.conversion_rates?.GBP,
            )
            CurrencyRow(
                iconDrawableId = R.drawable.round_currency_franc,
                currencyCode = Currency.CHF.name,
                exchangeRate = exchangeRates?.conversion_rates?.CHF,
            )
            CurrencyRow(
                iconDrawableId = R.drawable.round_currency_yen,
                currencyCode = Currency.JPY.name,
                exchangeRate = exchangeRates?.conversion_rates?.JPY,
            )
        }
    }
}
